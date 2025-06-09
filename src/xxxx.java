public class xxxx {
    public static void main(String[] args) {
//        System.out.println("Justified Output:");
      justifyText("i play cricket", 25);

//        int[] array = {7, 7, 3, 3, 3, 11, 6, 9, 11, 3, 7, 3};
//        System.out.println("\nTop 3 Frequent Elements:");
//        top3FrequentElements(array);

//        int[] inputAlt = {17, 11, 7, 9, 14, 3, 6};
//        System.out.println("\nMin Alternate Order:");
//        minAlternate(inputAlt);
    }

    public static void top3FrequentElements(int[] array) {
        int len = array.length;
        int[] frequency = new int[len];
        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            int count = 1;
            for (int j = i + 1; j < len; j++) {
                if (array[i] == array[j]) {
                    count++;
                    visited[j] = true;
                }
            }
            frequency[i] = count;
        }
        for (int k = 0; k < 3; k++) {
            int maxFreq = 0, maxIndex = -1;
            for (int i = 0; i < len; i++) {
                if (frequency[i] > maxFreq) {
                    maxFreq = frequency[i];
                    maxIndex = i;
                }
            }
            if (maxIndex != -1) {
                System.out.println("Top " + (k + 1) + ": " + array[maxIndex] + "  " + frequency[maxIndex] + " times");
                frequency[maxIndex] = -1;
            }
        }
    }
    public static void justifyText(String input, int width) {
        int len = input.length();
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == ' ') spaceCount++;
        }

        int extraSpaces = width - len;
        if (spaceCount == 0 || extraSpaces == 0) {
            System.out.println(input);
            return;
        }

        int evenSpace = extraSpaces / spaceCount;
        int extra = extraSpaces % spaceCount;


        int i = 0;
        while (i < len)
        {
            char ch = input.charAt(i);
            System.out.print(ch);
            if(ch==' ')
            {
                for (int j = 0; j < evenSpace; j++)
                    System.out.print(" ");
                if (extra > 0) {
                    System.out.print(" ");
                    extra--;
                }
            }
            i++;
        }

    }
    public static void minAlternate(int[] array) {
        int n = array.length;
        // Selection sort till needed
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            // swap
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        for (int i = 0; i < n; i += 2)
            System.out.print(array[i] + " ");
        for (int i = 1; i < n; i += 2)
            System.out.print(array[i] + " ");
        System.out.println();
    }


}
