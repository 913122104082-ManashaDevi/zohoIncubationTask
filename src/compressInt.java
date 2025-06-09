public class compressInt {
        public static void compressInteger(int value) {
            int pos = countPosDigits(value);

            if (value <= 9) {
                System.out.println("1" + value);
                return;
            }

            int lastDigit = value / pos;
            int countSame = 1;
            value = value % pos;
            pos = pos / 10;
            while (pos > 0) {
                int currentDigit = value / pos;
                value = value % pos;
                pos = pos / 10;
                if (currentDigit == lastDigit) {
                    countSame++;
                } else {
                    System.out.print(countSame + "" + lastDigit);
                    lastDigit = currentDigit;
                    countSame = 1;
                }
            }
            System.out.print(countSame + "" + lastDigit);
        }

        public static int countPosDigits(int value) {
            int pos = 1;
            while (value >= 10) {
                value = value / 10;
                pos = pos * 10;
            }
            return pos;
        }

        public static void main(String args[]){
            compressInteger(77999);
        }
}
