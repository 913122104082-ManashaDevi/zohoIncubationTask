public class PATTERNS_NUMERICAL {
    public static void main(String[] args){
       // pattern1(3);
        System.out.println("**************************");
        //pattern2(4);
        // babylonionSquareRoot(16);
        //siameseMagicSquare(3);
        //sqvalue(5);
        // problem5();
        //diagonalsquare();
        // apgp(5, 3,5,"ap");
        //AlternateSort();
        //decimalToDifferentFormat(586, 26);
        // CompressString("AAAABBRCNDDD");
        System.out.println("**************************");

    }
    public static void CompressString(String input) {
        StringBuilder result = new StringBuilder();
        int n = input.length();
        int i = 0;
        while (i < n) {
            char current = input.charAt(i);
            int currentCount = 1;
            while (i + 1 < n && input.charAt(i + 1) == current) {
                currentCount++;
                i++;
            }
            if (currentCount > 1)
                result.append(currentCount);
            result.append(current);
            i++;
        }
        System.out.println("answer :  "+result);
    }

    private static void pattern1(int n) {
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                for(int j = 0; j < n; j++){
                    System.out.printf("%4d",i*n+j+1);
                }
            }else{
                for(int j = 0; j < n; j++){
                    System.out.printf("%4d",i*n+(n-j));

                }
            }
            System.out.println();
        }
    }

    private static void pattern2(int n){
        for(int i=1;i<=n;i++){
            if(i%2==0){
                for(int j=1;j<=n;j++){
                    System.out.printf("%4d",(i-2)*n+(j*2));
                }
            }else{
                for(int j=1;j<=n;j++){
                    System.out.printf("%4d",(i-1)*n+2*j-1);
                }
            }
            System.out.println();
        }
    }
    private static void siameseMagicSquare(int n){
        int[][] magicSquare = new int[n][n];

        int num = 1;
        int i = 1;
        int j = 1;

        while (num <= n * n) {
            magicSquare[i][j] = num;
            num++;

            int newi = (i - 1 + n) % n;
            int newj = (j + 1) % n;

            if (magicSquare[newi][newj] != 0) {

                j= (j - 1 + n) % n;
            } else {
                i = newi;
                j = newj;
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void babylonionSquareRoot(int n){
        float guess=n/2;
        float blwacc=(float) (n-0.002);
        float abacc= (float) (n+0.002);
        float newguess;
        while(true)
        {
            newguess=(guess + n/guess)/2;
            float sqr=newguess*newguess ;
            guess=newguess;
            if(blwacc <= sqr &&  sqr <=abacc)
                break;

        }
        System.out.println("square root is "+ guess);
    }
    private static void crspattern2(int n){
        int diff=0;
        int a=1;
        for(int i=1;i<=n;i++){
                System.out.printf("%4d",a);
                for(int j=n-i;j<=n;j++){
                    System.out.printf("%4d",(i-2)*n+(j*2));

                }

            System.out.println();
        }

    }
    private static void sqvalue(int n){

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)
            {
             if(i<j)
             {   if((n-1-j)<i)
                    System.out.printf("%4d",j);
                 else
                     System.out.printf("%4d",i);
             }
             else
             {
                 if((n-1-i)<j)
                    System.out.printf("%4d",i);
                 else
                    System.out.printf("%4d",j);
             }
            }

            System.out.println();
        }

    }

        public static void problem11() {
            int n = 5;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int min = Math.min(Math.min(i, j), Math.min(n - 1 - i, n - 1 - j));
                    System.out.print((min + 1) + " ");
                }
                System.out.println();
            }
        }
    public static void problem112() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min1,min2;
                if(i<j)
                    min1 =i;
                else
                    min1 =j;
                if(n - 1 - i < n - 1 - j)
                    min2 = n-1-i;
                else
                    min2 = n-1-j;
                if(min1>min2)
                    min1=min2;
                System.out.print((min1 + 1) + " ");
            }
            System.out.println();
        }
    }
    public static void problem12() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.max(Math.max(i, j), Math.max(n - 1 - i, n - 1 - j));
                System.out.print((min + 1) + " ");
            } 
            System.out.println();
        }
    }

        public static void problem3() {
            int n = 7;
            int num = 1;

            for (int i = 1; i <= n; i++) {
                int count;
                if (i <= n/2)
                    count = i;
                 else
                    count = n+1 - i;


                for (int j = 1; j <= count; j++) {
                    System.out.print(num + " ");
                    num++;
                }
                System.out.println();
            }
        }
        public static void problem4() {
            int n = 5;
            int num;
            for (int i = 1; i <= n; i++)
            {
                num = i;
                for (int j = 1; j <= n - Math.abs(n / 2 - i + 1); j++) {
                    System.out.print(num + " ");
                    num += (n - j);
                }
                System.out.println();
            }
        }
    public static void problem5() {
        int n = 7;
        int num = 1;

        for (int i = 1; i <= n; i++) {
            int count;
            if (i <= n/2)
                count = i;
            else
                count = n+1 - i;


            for (int j = 1; j <= count; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }


        public static void diagonalsquare1() {
            int n = 8;
            int num = 1;
            int sign = 1;


            for (int i = 1; i <= n; i++) {
                num = 0;
                int limit = (i % 2 == 1) ? i / 2 + 1 : i / 2;


                for (int k = 1; k <= n - i; k++)
                    System.out.print(" ");
                for (int j = 1; j <= i; j++) {
                    num = num + sign;
                    System.out.print(num + " ");

                    if (j == limit) {
                        if (i % 2 == 0) {
                            System.out.print(num + " ");
                            j++;
                        }
                        sign = -1;
                    }
                }
                sign = 1;
                System.out.println();
            }

            for (int i = n - 1; i >= 1; i--) {
                num = 0;
                int limit = (i % 2 == 1) ? i / 2 + 1 : i / 2;
                for (int k = 1; k <= n - i; k++)
                    System.out.print(" ");
                for (int j = 1; j <= i; j++) {
                    num = num + sign;
                    System.out.print(num + " ");
                    if (j == limit) {
                        if (i % 2 == 0) {
                            System.out.print(num + " ");
                            j++;
                        }
                        sign = -1;
                    }
                }
                sign = 1;
                System.out.println();
            }
        }
    public static void diagonalsquare() {
        int n = 8;
        for (int i = 1; i <= (2 * n - 1); i++) {
            int row = i <= n ? i : 2 * n - i;
            int limit = row / 2 + (row % 2);
            int num = 0;
            int sign = 1;
            for (int s = 0; s < n - row; s++) {
                System.out.print(" ");
                for (int j = 1; j <= row; j++) {
                    num += sign;
                    System.out.print(num + " ");
                    if (j == limit) {
                        if (row % 2 == 0) {
                            System.out.print(num + " ");
                            j++;
                        }
                        sign = -1;
                    }
                }
                System.out.println();
            }

        }

    }
    public static void apgp(int a, int d,int n,String type)
    {
        int start = a;
        System.out.print(start + " ");
        int add=0,mul=d;
        if(type=="ap")
        {
            add=d;
            mul=1;
        }
        for (int i = 1; i < n; i++) {
            start= start * mul+add;
            System.out.print(start+" ");
        }

    }




    public static void AlternateSort() {
        int[] arr = {10,3,15,5,4,6,1};
        int n = arr.length;

        for (int i = 0; i < n - 1; i += 2) {
            int min = i, max = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
                if (arr[j] > arr[max]) max = j;
            }

            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            if (min == i)
                min = max;

            temp = arr[i + 1];
            arr[i + 1] = arr[min];
            arr[min] = temp;

        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
//    public static void decimaltoodifferntformat(int value,int base)
//    {   int decimal=value;
//        //base upto 36
//        // eg value 17 base 3 answer "122"
//        int [] representation={0,1,2,3,4,5,6,7,8,9};
//        StringBuilder result= new StringBuilder();
//        int quotient;
//        int remainder;
//        while(true)
//        {   quotient= decimal/base;
//            remainder= decimal%base;
//            result.append(remainder);
//            decimal=quotient;
//        }
//        System.out.println(" answer :"+result.reverse());
//
//    }
//    public static void decimalToDifferentFormat(int value, int base) {
//        String[] representation = {"0","1","2","3","4","5","6","7","8","9", "A","B","C","D","E","F","G","H","I","J", "K","L","M","N","O","P","Q","R","S","T", "U","V","W","X","Y","Z"};
//        StringBuilder result = new StringBuilder();
//        int decimal = value;
//        if (base < 2 || base > 36) {
//            System.out.println("Base 2 and 36.");
//            return;
//        }
//        if (value == 0)
//            System.out.println("answer: 0");
//
//        while (decimal > 0) {
//            int remainder = decimal % base;
//            result.append(representation[remainder]);
//            decimal = decimal / base;
//        }
//        System.out.println("answer: " + result.reverse());
//    }
public static void decimalToDifferentFormat(int value, int base) {
    StringBuilder result = new StringBuilder();
    if (value == 0) {
        System.out.println("answer: 0");
    }
    while (value > 0) {
        int remainder = value % base;
        char ans;
        if(remainder < 10 )
            ans=(char)('0' + remainder);
        else
           ans=(char)('A' + remainder -10);
        result.append(ans);
        value /= base;
    }
    System.out.println("answer: " + result.reverse());
}












}















