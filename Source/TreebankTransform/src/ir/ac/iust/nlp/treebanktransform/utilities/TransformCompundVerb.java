package ir.ac.iust.nlp.treebanktransform.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mojtaba Khallash
 */
public class TransformCompundVerb extends Transform {
    
    private static String name = "Valency Lexicon Ver. 2.2.txt";
    
    private static HashMap<String, HashSet<String>> map = null;
    
    public TransformCompundVerb() {
        if (map == null)
            readList();
    }
    
    private void readList() {
        try {
            InputStream is = TransformCompundVerb.class.getClassLoader().getResourceAsStream(name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "UTF8"));
            
            map = new HashMap<>();
            
            reader.readLine();
            reader.readLine();
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\t");
                String Mazi = split[0];
                String Mozare = split[1];
                String Prefix = split[2];
                String NonVerbalElement = split[3];
                String VerbParticle = split[4];

                String Lemm = "";
                if (!Prefix.equals("-"))
                    Lemm = Prefix + "#";
                if (!Mazi.equals("-"))
                    Lemm += Mazi;
                Lemm += "#" + Mozare;

                HashSet<String> list = map.get(Lemm);
                if (list == null) {
                    list = new HashSet<>();
                }
                list.add(VerbParticle + "," + NonVerbalElement);
                map.put(Lemm, list);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot Find Cotpus File:");
            System.out.println("  - " + name);
            System.exit(1);
        } catch (Exception ex) {
            System.exit(1);
        }
    }
    
    public void applyTransform() {
        int size = tokens.size();
        String before1 = "-";
        String before2 = "-";
                
        for (int i = 0; i < size; i++){
            Token t = tokens.get(i);
            if (t.cpos.equals("V")) {
                HashSet<String> list = map.get(t.lemma);
                
                if (list != null) {
                    if (list.contains(before1 + "," + before2)) {
                        markCompoundVerb(i, before1, before2);
                        size-=2;
                        i--;
                    }
                    else if (list.contains(before2 + ",-")) {
                        markCompoundVerb(i, "-", before2);
                        size--;
                    }
                    else if (list.contains("-," + before2)) {
                        markCompoundVerb(i, before2, "-");                    
                        size--;
                    }
                }
            }
            
            before1 = before2;
            before2 = t.lemma;
        }
    }
    
    private void markCompoundVerb(int index, String NVE, String VPRT) {
        int size = tokens.size();
         
        int oldHead = index;
        int newHead = index;
        int count = 0;
        if (!NVE.equals("-"))
            count++;
        if (!VPRT.equals("-"))
            count++;
        newHead -= count;
         
        List<Token> newTokens = new LinkedList<>();
       
        for (int i = 0; i < size; i++){
            Token t = tokens.get(i);
            if (newHead == i) {
                String verb = t.form;
                for (int j = 1; j <= count; j++) {
                    t = tokens.get(i + j);
                    verb += " " + t.form;
                }
                t.form = verb;
                t.id = newHead + 1;
                i += count;
                newTokens.add(t);
            }
            else {
                if (t.head == oldHead + 1)
                    t.head = newHead + 1;
                else if (t.head > oldHead + 1)
                    t.head -= count;

                if (t.id > oldHead + 1)
                    t.id -= count;
                newTokens.add(t);
            }
        }
        
        tokens = newTokens;
   }
}