package MultiplyEquations;

import java.util.ArrayList;

public class WholeEquation {

    private ArrayList<Equation> terms = new ArrayList<>();

    public WholeEquation() {}

    public WholeEquation(String input) {
        input = input.replace(" ", "").replaceAll("(?=[+-])", " ");;
        System.out.println(input);
        for (String term : input.trim().split(" "))
                terms.add(new Equation(term));
    }

    public static WholeEquation multiply(WholeEquation eq1, WholeEquation eq2) {
        WholeEquation result = new WholeEquation();
        for (Equation term1 : eq1.terms)
        {
            for (Equation term2 : eq2.terms)
            {
                Equation ans=term1.multiply(term2);
                for(Equation trm: result.terms)
                {
                    if(ans.isLikeTerm(trm))
                    {
                        ans.coef+=trm.coef;
                       result.terms.remove(trm);
                       break;
                    }
                }
                result.terms.add(ans);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Equation term : terms) {
            output.append(term);
        }
        return output.toString();
    }


    public static void main(String[] args) {
        WholeEquation eq1 = new WholeEquation("xy + 8x^2y^3 - 9xy");
        WholeEquation eq2 = new WholeEquation("2x - y^3");

        WholeEquation result = WholeEquation.multiply(eq1, eq2);
        System.out.println("Result of : (xy + 8x^2y^3 - 9xy) * (2x - y^3)");
        System.out.println(result);
    }
}
