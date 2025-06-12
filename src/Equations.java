public class Equations {
    String variables[][]=new String[10][10];
    int pow[][]=new int[10][10];
    int termsInEachVariable[]=new int[10];
    int values[]=new int[10];
    int no_of_parts;
    public static void parse(String equ){
        //input1 "-8x + 9x^2y^2 -13xyz "
        //output1
        // no_of_parts=3;
        // values={-8,9,-13};
        //variables={{x},{x,y},{x,y,z}};
        //pow      ={{1},{2,2},{1,1,1}}
        // termsInEachVariable={1,2,3}
    }
//    public String equationToString(Equations equ){
//
//    }
//    public Equations multiplyEquations(Equations eq1,Equations eq2){
//
//    }

//    public String equationToString(Equations equ) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < equ.no_of_parts; i++) {
//            int coef = equ.values[i];
//
//            if (i > 0) {
//                sb.append(coef >= 0 ? " + " : " - ");
//                coef = Math.abs(coef);
//            } else if (coef < 0) {
//                sb.append("-");
//                coef = Math.abs(coef);
//            }
//
//            sb.append(coef);
//
//            for (int j = 0; j < equ.termsInEachVariable[i]; j++) {
//                sb.append(equ.variables[i][j]);
//                if (equ.pow[i][j] > 1) {
//                    sb.append("^").append(equ.pow[i][j]);
//                }
//            }
//        }
//
//        return sb.toString();
//    }

}
