public class Zohoproblems {
    public static void main(String args[]) {
        System.out.println(wildCard());
    }

    public static boolean wildCard() {
        String a = "abcdebeeef";
        String b = "a*d*b********f";
        int front1 = 0;
        int front2 = 0;
        int starIndex = -1;

        while (front1 < a.length())
        {
            if (front2 < b.length() && (a.charAt(front1) == b.charAt(front2) || b.charAt(front2) == '?')) {
                front1++;
                front2++;
            } else if (front2 < b.length() && b.charAt(front2) == '*') {
                starIndex = front2;
                front2++;
            } else if (starIndex != -1) {;
                front1++;
                front2 = starIndex + 1;
            } else
            {
                return false;
            }
        }

        while (front2 < b.length() && b.charAt(front2) == '*') {
            front2++;
        }

        return front2 == b.length();
    }

}
