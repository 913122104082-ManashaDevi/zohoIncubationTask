public class progress {
    public static void main(String[] args){

        System.out.println("**************************");

        //GreatestStringBetweenTwoVowel("amjlxiqmi");
//        GreatestStringBetweenTwoVowel("string");
//        GreatestStringBetweenTwoVowel("manasha");
//        GreaterElement2();
        int[] array = {7, 9, 13, 5, 3, 15};
        blockwiseReverse(array);

    }
    public static void reverse(int start,int end,int[] array)
    {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void blockwiseReverse(int[]array) {
        int blocksize = 4;
        int n = array.length;

        for (int i = 0; i < n; i += blocksize) {
            int start = i;
            int end = Math.min(i + blocksize - 1, n - 1);
            reverse(start,end,array);
        }
        for (int num : array) {
            System.out.print(num + " ");
        }

    }
    public static int factor(int n) {
        int factorAns = 2;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                factorAns++;
        }
        return factorAns;
    }

    public static void sortbasedOnfactor() {
        int[] array = {7, 9, 13, 5, 3, 15};
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                int factorMin = factor(array[minIndex]);
                int factorJ = factor(array[j]);
                if (factorJ < factorMin)
                {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

        }
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void GreaterElement() {
        int[] array = {7, 9, 13, 5, 3, 15};
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[i]) {
                    array[i] = array[j];
                    found = true;
                    break;
                }
            }
            if (!found) {
                array[i] = -1;
            }
        }
        array[n - 1] = -1;
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
    public static void GreaterElement2() {
        int[] array = {9,3,11,4};
        int n = array.length;
        int maxvalue=0;
        for(int i = 0; i < n ; i++) {
            if(array[i]>maxvalue)
                maxvalue=array[i];
        }
        for (int i = 0; i < n - 1; i++) {
            int minDiff = maxvalue;
            int replacement = -1;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[i]) {
                    int diff = array[j] - array[i];
                    if (diff < minDiff) {
                        minDiff = diff;
                        replacement = array[j];
                    }
                }
            }

            array[i] = replacement;
        }
        array[n - 1] = -1;

        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void GreatestStringBetweenTwoVowel(String input) {
        String str = 'a' + input + 'a';
        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int maxDiff = 0;

        for (int i = 1; i < str.length(); i++) {
            if (isVowel(str.charAt(i)))
            {
                int end = i;
                int diff=end - start - 1;
                if (diff > maxDiff) {
                    maxDiff = diff;
                    maxStart = start + 1;
                    maxEnd = end - 1;
                }
                start = i;
            }
        }
        if (maxDiff > 0) {
            System.out.println(input+ " result :" + input.substring(maxStart - 1, maxEnd)+"\n");
        } else {
            System.out.println("No string");
        }
    }
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }























}
