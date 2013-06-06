package ir.ac.iust.nlp.treebanktransform.utilities;

import ir.ac.iust.nlp.treebanktransform.enums.NumberTransferType;
import ir.ac.iust.nlp.treebanktransform.enums.POSCopyType;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mojtaba Khallash
 */
public class Transform {
    
    protected List<Token> tokens;

    private boolean reverse;
    private Object[] adds;
    private Object[] removes;
    private boolean copyLem2Form;
    private boolean removeSpaces;
    private POSCopyType copyPOS;
    private boolean removeDeprelHead;
    private TransformCompundVerb compoundVerb;
    
    public static void PostProcessSentence(String sourcePath, String destPath, 
            boolean reverse, TransformNumber number, boolean copyLem2Form, 
            boolean removeSpaces,POSCopyType copyPOS, 
            Object[] removes, Object[] adds, 
            boolean removeDeprelHead, TransformRa ra, boolean setDeprelROOT,
            boolean markCompoundVerb) throws Exception {
        
        Transform t = new Transform();
        t.tokens = new LinkedList<>();
        
        t.reverse = reverse;
        t.removes = removes;
        t.adds = adds;
        t.copyLem2Form = copyLem2Form;
        t.removeSpaces = removeSpaces;
        t.copyPOS = copyPOS;
        t.removeDeprelHead = removeDeprelHead;
        
        if (markCompoundVerb == true) {
            t.compoundVerb = new TransformCompundVerb();
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(sourcePath), "UTF8")); 
             Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(destPath, true), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() != 0) {
                    t.parseLine(line);
                }
                else {
                    // Mark Compound Verb
                    if (markCompoundVerb == true) {
                        t.compoundVerb.tokens = t.tokens;
                        t.compoundVerb.applyTransform();
                        t.tokens = t.compoundVerb.tokens;
                    }
                    
                    // Read a complete sentence
                    int size = t.tokens.size();

                    // Apply Transforms
                    for (int i = 0; i < size; i++)
                    {
                        if (ra != null) {
                            ra.tokens = t.tokens;
                            ra.applyTransform(i);
                        }
                        else if (number != null && number.getType() != NumberTransferType.None) {
                            number.tokens = t.tokens;
                            number.applyTransform(i);
                        }
                        
                        if (setDeprelROOT && t.tokens.get(i).head == 0) {
                            t.tokens.get(i).label = "ROOT";
                        }
                    }
                    
                    // Write new Sentence in output
                    if (reverse == false) {
                        for (int i = 0; i < size; i++) {
                            t.writeToken(writer, i);
                        }
                    }
                    else {
                        for (int i = size - 1; i >= 0; i--) {
                            t.writeToken(writer, i);
                        }
                    }
                    writer.write("\n");
                    t.tokens = new LinkedList<>();
                }
            }
        }
    }
    
    private void parseLine(String line) {
        String[] split = line.split("\t");

        int id = Integer.parseInt(split[0]);
        String lexeme = split[1];
        String lemma = split[2];
        String cpos = split[3];
        String fpos = split[4];
        String feat = split[5];
        int head = Integer.parseInt(split[6]);
        String dependency = split[7];

        tokens.add(new Token(id,lexeme, lemma, cpos, fpos, feat, head, dependency));       
    }
    
    private void writeToken(Writer writer, int index) throws Exception {
        if (copyLem2Form == true) {
            tokens.get(index).form = tokens.get(index).lemma;
        }
        if (removeSpaces == true) {
            tokens.get(index).form = tokens.get(index).form.replace(" ", "_");
            tokens.get(index).lemma = tokens.get(index).lemma.replace(" ", "_");
        }
        
        switch(copyPOS) {
            case CPOS2FPOS:
                tokens.get(index).pos = tokens.get(index).cpos;
                break;
            case FPOS2CPOS:
                tokens.get(index).cpos = tokens.get(index).pos;
                break;
        }

        if (removeDeprelHead == true) {
            tokens.get(index).label = "_";
            tokens.get(index).head = 0;
        }

        String feats = tokens.get(index).feats;
        // FEATS Column
        
        if (removes.length != 0) {
            if (Arrays.binarySearch(removes, "all") != -1) {
                feats = "_";
            }
            else {
                List<String> vals = new LinkedList<>();
                String[] parts = tokens.get(index).feats.split("[|]");
                for (int k=0; k<parts.length;k++) {
                    String[] strs = parts[k].split("=");
                    if (Arrays.binarySearch(removes, strs[0]) < 0) {
                        vals.add(parts[k]);
                    }
                }
                
                String res = "_";
                for (int l=0; l< vals.size(); l++) {
                    if (res.equals("_")) {
                        res = vals.get(l);
                    }
                    else {
                        res += "|" + vals.get(l);
                    }
                }
                feats = res;
            }
        }
        if (adds.length != 0) {
            for (int k=0; k<adds.length;k++) {
                String[] parts = tokens.get(index).feats.split("[|]");
                for (int l=0; l< parts.length; l++) {
                    if (parts[l].startsWith(adds[k].toString())) {
                        if (feats.equals("_")) {
                            feats = parts[l];
                        }
                        else {
                            feats += "|" + parts[l];
                        }
                    }
                }
            }
        }
        tokens.get(index).feats = feats;
        
        if (reverse) {
            tokens.get(index).id = tokens.size() + 1 - tokens.get(index).id;
            if (tokens.get(index).head != 0) {
                tokens.get(index).head = tokens.size() + 1 - tokens.get(index).head;
            }
        }
        
        writer.write(tokens.get(index).toString() + "\n");       
    }
}