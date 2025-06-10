//public class NextPalindrome1 {
//    public static void main(String args[]) {
//        System.out.println(palindromeGenerator1(1234)); // Output: 1331
//    }
//
//    private static int palindromeGenerator1(int value) {
//        String s = String.valueOf(value);
//        int len = s.length();
//        int half = (len + 1) / 2;
//
//        String left = s.substring(0, half);
//        StringBuilder sb = new StringBuilder(left);
//
//        // Mirror the left to create a candidate palindrome
//        String candidate = left + sb.reverse().substring(len % 2);
//        int candidateVal = Integer.parseInt(candidate);
//
//        if (candidateVal > value) return candidateVal;
//
//        // If not greater, increment the left half and mirror again
//        int leftNum = Integer.parseInt(left);
//        leftNum++;
//
//        String newLeft = String.valueOf(leftNum);
//        StringBuilder newSb = new StringBuilder(newLeft);
//        String newPalindrome = newLeft + newSb.reverse().substring(len % 2);
//
//        return Integer.parseInt(newPalindrome);
//    }
//
//    public static int countDigits(int value) {
//        int count = 0;
//        while (value > 0) {
//            count++;
//            value /= 10;
//        }
//        return count;
//    }
//    private static int createPalindrome(int left, boolean isOdd) {
//        int result = left;
//        int reverse=0;
//        if (isOdd)
//            left /= 10;
//        while (left > 0) {
//            result = result* 10 + (left % 10);
//            left /= 10;
//        }
//        return result * (int) Math.pow(10, countDigits(reverse)) + reverse;
//    }
//}
//
//
