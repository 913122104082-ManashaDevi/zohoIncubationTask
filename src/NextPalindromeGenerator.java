public class NextPalindromeGenerator {
    public static void main(String[] args) {
        System.out.println(palindromeGenerator(12344)); // Output: 12421  // 123 131 //99 101 //9999 10001
    }

    private static int palindromeGenerator(int value) {
        int digits = countDigits(value);
        int halfLen = digits / 2;

        int pow = (int)Math.pow(10, halfLen);
        int left = value / pow;
        int palindrome = createPalindrome(left, digits % 2 == 1);
        if (palindrome > value)
            return palindrome;
        if(countDigits(left+1)>countDigits(left))
            return createPalindrome(left+1, ! (digits % 2 == 1));
        return createPalindrome(left, digits % 2 == 1);
    }

    private static int createPalindrome(int left, boolean isOdd) {
        int result = left;
        if (isOdd)
            left /= 10;
        while (left > 0) {
            int remainder=left % 10;
            result = result * 10 + remainder;
            left /= 10;
        }
        return result;
    }

    public static int countDigits(int value) {
        int count = 0;
        while (value > 0) {
            count++;
            value /= 10;
        }
        return count;
    }
}
