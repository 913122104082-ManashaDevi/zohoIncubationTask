public class progressday2 {
    public static void main(String[] args) {
        //leftRotate(12345, 2);
        // rightRotate(12345, 2);
        //decimalToDifferentFormat(7);
        int[] array = {2,4,1,3,4,9,7,8};
        reverseWithEvenValuesAtSamePostion(array);
    }
    public static void leftRotate(int input, int nRotate) {
        int digits = countDigits(input);
        nRotate = nRotate % digits;
        if (nRotate == 0) {
            System.out.println(input);
            return;
        }
        int pow = (int) power(10, digits - nRotate);
        int leftPart = input / pow;
        int rightPart = input % pow;
        int rotated = rightPart * (int) power(10, nRotate) + leftPart;
        System.out.println(rotated);
    }
    public static void rightRotate(int input, int nRotate) {
        int digits = countDigits(input);
        nRotate = nRotate % digits;
        if (nRotate == 0) {
            System.out.println(input);
            return;
        }
        int pow = (int) power(10, nRotate);
        int leftPart = input / pow;
        int rightPart = input % pow;
        int rotated = rightPart * (int) power(10, digits - nRotate) + leftPart;
        System.out.println(rotated);
    }
    private static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }
    public static void decimalToDifferentFormat(int value) {
        int zeros = 0;
        int ones = 0;
        int base = 2;
        if (value == 0) {
            System.out.println("zeros:1 ones:0");
        }
        while (value > 0) {
            int remainder = value % base;
            if (remainder == 0)
                zeros++;
            else
                ones++;
            value /= base;
        }
        System.out.println("zeros :" + zeros + "\nones :" + ones);
    }


    //    public static void reverseWithEvenValuesAtSamePostion(int[] array){
//        int n=array.length;
//        int left=0;
//        int right=n;
//        while(left<right){
//            while(left%2==0&& left<n)
//                left++;
//            while(right%2==0 && right>0)
//                right--;
//            //swap(left,right,array)
//
//        }
    public static void reverseWithEvenValuesAtSamePostion(int[] array) {
        int n = array.length;
        int left = 0;
        int right = n - 1;

        while (left < right && left < n ) {
            if(array[left] % 2 == 0) {
                left++;
                continue;
            }
            if( array[right] % 2 == 0){
                right--;
                continue;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

        }
        System.out.println();
        for (int num : array)
            System.out.print(num + ", ");

    }

}






