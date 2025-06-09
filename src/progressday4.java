//import java.util.*;
//
//public class progressday4 {
//
//    public static void main(String[] args) {
//        System.out.println("Justified Output:");
//        justifyText("i play cricket", 25);
//
//        int[] array = {7, 7, 3, 3, 3, 11, 6, 9, 11, 3, 7, 3};
//        System.out.println("\nTop 3 Frequent Elements:");
//        top3Frequent(array);
//
//        int[] inputAlt = {17, 11, 7, 9, 14, 3, 6};
//        System.out.println("\nMin Alternate Order:");
//        minAlternate(inputAlt);
//    }
//
//    // ✅ 1. Justify Text Logic
//    public static void justifyText(String input, int width) {
//        String[] words = input.split(" ");
//        int totalSpaces = width - input.replace(" ", "").length();
//        int gaps = words.length - 1;
//
//        if (gaps == 0) {
//            System.out.println(words[0] + " ".repeat(totalSpaces));
//            return;
//        }
//
//        int spacePerGap = totalSpaces / gaps;
//        int extraSpaces = totalSpaces % gaps;
//
//        StringBuilder justified = new StringBuilder();
//        for (int i = 0; i < words.length - 1; i++) {
//            justified.append(words[i]);
//            justified.append(" ".repeat(spacePerGap));
//            if (extraSpaces-- > 0) justified.append(" ");
//        }
//        justified.append(words[words.length - 1]);
//        System.out.println(justified);
//    }
//
//    // ✅ 2. Top 3 Frequent Elements Logic
//    public static void top3Frequent(int[] array) {
//        Map<Integer, Integer> freqMap = new HashMap<>();
//        for (int num : array)
//            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
//        list.sort((a, b) -> b.getValue() - a.getValue());
//
//        for (int i = 0; i < Math.min(3, list.size()); i++) {
//            System.out.println("Element: " + list.get(i).getKey() + ", Frequency: " + list.get(i).getValue());
//        }
//    }
//
//    // ✅ 3. Minimum Alternate Logic
//    public static void minAlternate(int[] array) {
//        Arrays.sort(array);
//        List<Integer> result = new ArrayList<>();
//
//        int n = array.length;
//        int i = 0, j = n - 1;
//
//        // First min, third min,... (odd index in sorted)
//        while (i < j) {
//            result.add(array[i++]);
//            result.add(array[j--]);
//        }
//
//        if (i == j) result.add(array[i]); // middle element if odd count
//
//        System.out.println(result);
//    }
//}
