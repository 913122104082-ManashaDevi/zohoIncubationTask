public class Equation {
    String variables[][]=new String[10][10];  //
    int pow[][]=new int[10][10];
    int termsInEachVariable[]=new int[10];
    int values[]=new int[10];
    int no_of_parts;
    public void parse(String equ)
    {
        equ = equ.replaceAll(" ", "");
        equ = equ.replaceAll("(?=[+-])", " ");
        String[] parts = equ.trim().split(" ");
        no_of_parts = parts.length;
        for (int i = 0; i < no_of_parts; i++) {
            String part = parts[i];
            int sign = 1;
            if (part.charAt(0) == '-') {
                sign = -1;
                part = part.substring(1);
            } else if (part.charAt(0) == '+') {
                part = part.substring(1);
            }

            int j = 0;
            while (j < part.length() && (Character.isDigit(part.charAt(j)) || part.charAt(j) == '-')) j++;

            values[i] = sign * Integer.parseInt(part.substring(0, j));
            String varPart = part.substring(j);

            int varIndex = 0;
            while (!varPart.isEmpty()) {
                char var = varPart.charAt(0);
                int power = 1;
                int k = 1;
                if (varPart.length() > 1 && varPart.charAt(1) == '^') {
                    k = 2;
                    int start = 2;
                    while (k < varPart.length() && Character.isDigit(varPart.charAt(k))) k++;
                    power = Integer.parseInt(varPart.substring(start, k));
                }

                variables[i][varIndex] = String.valueOf(var);
                pow[i][varIndex] = power;
                varPart = varPart.substring(k);
                varIndex++;
            }
            termsInEachVariable[i] = varIndex;
        }
    }



}
