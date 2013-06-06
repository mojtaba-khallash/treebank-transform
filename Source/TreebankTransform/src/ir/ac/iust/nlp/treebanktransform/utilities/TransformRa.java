package ir.ac.iust.nlp.treebanktransform.utilities;

/**
 *
 * @author Mojtaba Khallash
 */
public class TransformRa extends Transform {
    private final static String raValue = "را";
    
    private boolean caseLabelAdd = false;
    private boolean raConvert = true;
    private boolean vConJConvert = false;
    private boolean secondObjConvert = false;

    public TransformRa(boolean caseLabelAdd, 
            boolean raConvert, 
            boolean vConJConvert, 
            boolean secondObjConvert) {
        this.caseLabelAdd = caseLabelAdd;
        this.raConvert = raConvert;
        this.vConJConvert = vConJConvert;
        this.secondObjConvert = secondObjConvert;
    }
    
    public void applyTransform(int index) {
        Token token = tokens.get(index);
        String lexeme = token.form;
        int head = token.head;
        int newHeadNum;

        if (head > 0)
        {
            // Deprel
            String dependency = token.label;
            String cpos = token.cpos;

            Token headToken = tokens.get(token.head - 1);
            String headString = headToken.form;

            if (caseLabelAdd)
            {
                if (headString.equals(raValue))
                {
                    //dependency = "RA-DEP";
                }
            }
            if (raConvert)
            {
                if (headString.equals(raValue) && !dependency.equals("VPP") && !cpos.equals("PUNC"))
                {
                    //if (lexeme == "گردشگری")
                    //{

                    //}
                    int headofHeadId = index;
                    String headDependency = "ACC-CASE";

                    String parentDependency = headToken.label;
                    int grandParent = newHeadNum = headToken.head;
                    if (!parentDependency.equals("VPP"))
                    {
                        if (parentDependency.equals("PCONJ"))
                        {
                            headToken.label = "NCONJ";
                            newHeadNum = tokens.get(grandParent - 1).head;
                        }
                        if (parentDependency.equals("ACC-CASE"))
                        {
                            headToken.label = "NCONJ";
                            //   newHeadNum = treeDic[headItem.Value.Key].Value.Key;
                        }

                        // Change Ra: "Head=i" and "Deprel=ACC-CASE"
                        headToken.head = (index + 1);
                        headToken.label = headDependency;

                        // Change Current: "Head=newHeadNum" and "Deprel=ACC-CASE"
                        token.head = newHeadNum;
                        token.label = parentDependency;
                    }
                }
            }
            if (vConJConvert)
            {

            }
            if (secondObjConvert)
            {

            }
        }        
    }
}