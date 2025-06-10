public class nextGreaterPalindrome {

        public static void main(String[] args) {
            System.out.println(palindromeGenerator(1234455531));
            System.out.println(palindromeGenerator(99));
            System.out.println(palindromeGenerator(9999));
            System.out.println(palindromeGenerator(1));
            System.out.println(palindromeGenerator(9));
            System.out.println(palindromeGenerator(808));
        }

        private static int palindromeGenerator(int value) {
            if (value < 9)
                return value + 1;
            value=value+1;
            int digits = countDigits(value);
            int halfLen = (digits + 1)/2;
            int pow = (int) Math.pow(10, digits/2);
            int left = value / pow;
            int palindrome = createPalindrome(left, digits % 2 == 1);
            if (palindrome >= value)
                return palindrome;
            left += 1;
            return createPalindrome(left, digits % 2 == 1);
        }

        private static int createPalindrome(int left, boolean isOdd) {
            int result = left;
            if (isOdd)
                left /= 10;
            while (left > 0) {
                result = result* 10 + (left % 10);
                left /= 10;
            }
            return result ;
        }

        private static int countDigits(int value) {
            if (value == 0) return 1;
            int count = 0;
            while (value > 0) {
                count++;
                value /= 10;
            }
            return count;
        }
    }

