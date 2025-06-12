package MultiplyEquations;

import java.util.TreeMap;

public class Equation {
    int coef;
    TreeMap<String,Integer> variableAndPowers=new TreeMap<>();

    public Equation(String term) {
        coef = 1;
        int i = 0;
        if (term.startsWith("-"))
        {   coef = -1;  i++;  }
        else if (term.startsWith("+"))
            i++;


        StringBuilder number = new StringBuilder();
        while (i < term.length() && Character.isDigit(term.charAt(i))) {
            number.append(term.charAt(i));
            i++;
        }

        coef *= number.isEmpty() ?   1: Integer.parseInt(number.toString()) ;

        while (i < term.length() )
        {
            char ch = term.charAt(i);
            if (Character.isLetter(ch))
            {
                i++;
                int power = 1;
                if (i < term.length() && term.charAt(i) == '^')
                {
                    i++;
                    StringBuilder powStr = new StringBuilder();
                    while (i < term.length() && Character.isDigit(term.charAt(i))) {
                        powStr.append(term.charAt(i));
                        i++;
                    }
                    power = Integer.parseInt(powStr.toString());
                }
                 variableAndPowers.put(String.valueOf(ch),power);
            }
        }
    }

    public Equation multiply(Equation other) {
        Equation result = new Equation("1");
        result.coef = this.coef * other.coef;
        result.variableAndPowers.putAll(this.variableAndPowers);

        for (String key : other.variableAndPowers.keySet())
        {
            int pow= other.variableAndPowers.get(key);
            if(result.variableAndPowers.containsKey(key))
            {      pow+=result.variableAndPowers.get(key);
            }
            result.variableAndPowers.put(key,pow);
        }
        return result;
    }

    public boolean isLikeTerm(Equation other)
    {
        if (this.variableAndPowers.size() != other.variableAndPowers.size()) return false;
        for(String key:this.variableAndPowers.keySet())
        {   int pow=this.variableAndPowers.get(key);
            if(!other.variableAndPowers.containsKey(key) )
                return false;
            else if(pow!=other.variableAndPowers.get(key))
                return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("  ");
        sb.append(coef > 0 ? "+" : "").append(coef+" ");
        for (String key:this.variableAndPowers.keySet())
        {
            sb.append(key);
            int pow=this.variableAndPowers.get(key);
            if (pow != 1)
                sb.append("^").append(pow+" ");
        }
        return sb.toString();
    }
}
