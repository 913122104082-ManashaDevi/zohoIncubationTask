public class palindromeWordWise {

        public static boolean wordwisePalindrome(String input) {
            boolean ispalindrome = true;
            String newInput = input;
            int length = newInput.length();
            int frontleft = 0;
            int frontright = 1;
            int backright = length - 1;
            int backleft = length - 2;

            if (input.length() == 1)
                return true;

            while (frontright <= backleft) {
                while (frontright < length && newInput.charAt(frontright) != ' ')
                    frontright++;
                while (backleft >= 0 && newInput.charAt(backleft) != ' ')
                    backleft--;
                int len1 = frontright - frontleft ;
                int len2 = backright - backleft;

                if (len1 != len2)
                    return false;

                boolean currentcheck = checkEqual(frontleft , backleft+1, newInput, len1);
                if (!currentcheck)
                    return false;

                frontleft = frontright=1;
                frontright++;
                backright = backleft-1;
                backleft--;
            }
            return ispalindrome;
        }

        private static boolean checkEqual(int front, int back, String str, int length) {
            for (int i = 0; i < length; i++) {
                char letterfromWord1 = str.charAt(front + i);
                char letterfromWord2 = str.charAt(back + i);
                if (letterfromWord1 != letterfromWord2)
                    return false;
            }
            return true;
        }

        public static void main(String[] args) {
            System.out.println(wordwisePalindrome("i read i"));
            System.out.println(wordwisePalindrome("hello world hello"));
        }
    }


