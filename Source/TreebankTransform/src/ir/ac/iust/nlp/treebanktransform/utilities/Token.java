package ir.ac.iust.nlp.treebanktransform.utilities;

/**
 *
 * @author Mojtaba Khallash
 */
public class Token {

    int id;
    String form;
    String lemma;
    String pos;
    String cpos;
    String feats;
    int head;
    String label;

    public Token(int id, String f, String pos, int h, String lbl) {
        construct(id, f, pos, h, lbl);
    }

    public Token(int id, String f, String l, String cpos, String pos, String feats, int h, String lbl) {
        construct(id, f, cpos, h, lbl);
        
        this.lemma = l;
        this.pos = pos;
        this.feats = feats;
    }

    private void construct(int id, String f, String pos, int h, String l) {
        this.id = id;
        this.form = f;
        this.lemma = f;
        this.pos = pos;
        this.cpos = pos;
        this.feats = "_";
        this.head = h;
        this.label = l;
    }

    /**
     * Prints the token in CoNLL-X format
     */
    @Override
    public String toString() {
        StringBuilder os = new StringBuilder();
        os.append(id).append("\t").append(form).append("\t").append(lemma).append("\t").append(cpos).append("\t").append(pos).append("\t").append(feats).append("\t").append(head).append("\t").append(label.toUpperCase()).append("\t_\t_");
        return os.toString();
    }

    public boolean sameDependency(Token other) {
        if (head == other.head && label.equalsIgnoreCase(other.label)) {
            return true;
        }
        return false;
    }
}