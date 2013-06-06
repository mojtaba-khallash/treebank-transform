package ir.ac.iust.nlp.treebanktransform.utilities;

import ir.ac.iust.nlp.treebanktransform.enums.NumberTransferType;

/**
 *
 * @author Mojtaba Khallash
 */
public class TransformNumber extends Transform {

    private NumberTransferType type = NumberTransferType.None;
    public NumberTransferType getType() {
        return type;
    }
    
    public TransformNumber() {
        type = NumberTransferType.None;
    }
    
    public TransformNumber(NumberTransferType type) {
        this.type = type;
    }
            
    public void applyTransform(int index) {
        Token token = tokens.get(index);
        
        token.form = normalize(token.form);
        token.lemma = normalize(token.lemma);
    }
    
    private String normalize(String s) {
        if (s.matches("[0-9]+|[0-9]+\\.[0-9]+|[0-9]+[0-9,]+")) {
            switch(type) {
                case Normal:
                    return "<num>";
                case Binning:
                    // the number 0 and numbers ending with 00
                    if (s.equals("0") || s.endsWith("00"))
                        return "<num-bin0>";
                    // the number 1 and numbers ending with 01
                    else if (s.equals("1") || s.endsWith("01"))
                        return "<num-bin1>";
                    // the number 2 and numbers ending with 02
                    else if (s.equals("2") || s.endsWith("02"))
                        return "<num-bin2>";
                    // the numbers 3-10 and those ending with 03-10
                    else if (s.matches("[3-9]") || s.matches("([0-9]*)(0[3-9])") ||
                            s.equals("10") || s.endsWith("10"))
                        return "<num-bin3>";
                    // the numbers, and numbers ending with, 11-99
                    else if (s.matches("([0-9]*)((1[1-9])|([2-9][0-9]))"))
                        return "<num-bin4>";
                    // all other number tokens
                    else
                        return "<num-bin5>";
            }
        }
//        else if (s.matches("[۰-۹]+|[۰-۹]+\\.[۰-۹]+|[۰-۹]+[۰-۹,]+")) {
//            switch(type) {
//                case Normal:
//                    return "<num>";
//                case Binning:
//                    if (s.equals("۰") || s.endsWith("۰۰"))
//                        return "<num-bin0>";
//                    else if (s.equals("۱") || s.endsWith("۰۱"))
//                        return "<num-bin1>";
//                    else if (s.equals("۲") || s.endsWith("۰۲"))
//                        return "<num-bin2>";
//                    else if (s.matches("[۳-۹]") || s.matches("([۰-۹]*)(۰[۳-۹])") ||
//                            s.equals("۱۰") || s.endsWith("۱۰"))
//                        return "<num-bin3>";
//                    else if (s.matches("([۰-۹]*)((۱[۱-۹])|([۲-۹][۰-۹]))"))
//                        return "<num-bin4>";
//                    else
//                        return "<num-bin5>";
//            }
//        }

        return s;
    }
}