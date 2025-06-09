public class Progressday2second {
    public static void main(String[] args){
        System.out.println(binaryAddition(110, 1010)  );
    }


    public static int binaryAddition(int a, int b) {
        int result = 0;
        int carry = 0;
        int crtpos = 1;

        while (a > 0 || b > 0 ) {
            int lastA = a % 10;
            int lastB= b % 10;
            int sum = lastA + lastB + carry;
            int bitResult = sum % 2;
            carry = sum / 2;
            result += bitResult * crtpos;
            crtpos *= 10;
            a /= 10;
            b /= 10;
        }
        if( carry > 0)
            result += carry* crtpos;
        return result;
    }

//    public static void justifyText(String input, int width) {
//        String[] words = input.split(" ");
//        List<String> lineWords = new ArrayList<>();
//        int currentLineLength = 0;
//
//        for (String word : words) {
//            if (currentLineLength + word.length() + lineWords.size() > width) {
//                printJustifiedLine(lineWords, currentLineLength, width);
//                lineWords.clear();
//                currentLineLength = 0;
//            }
//            lineWords.add(word);
//            currentLineLength += word.length();
//        }
//
//
//        if (!lineWords.isEmpty()) {
//            StringBuilder lastLine = new StringBuilder();
//            for (int i = 0; i < lineWords.size(); i++) {
//                lastLine.append(lineWords.get(i));
//                if (i != lineWords.size() - 1) {
//                    lastLine.append(" ");
//                }
//            }
//            while (lastLine.length() < width) {
//                lastLine.append(" ");
//            }
//            System.out.println(lastLine.toString());
//        }
//    }
//
//    private static void printJustifiedLine(List<String> words, int totalWordsLength, int width) {
//        int spaceCount = width - totalWordsLength;
//        int gaps = words.size() - 1;
//        StringBuilder line = new StringBuilder();
//
//        if (gaps == 0) {
//            line.append(words.get(0));
//            while (line.length() < width) {
//                line.append(" ");
//            }
//        } else {
//            int evenSpace = spaceCount / gaps;
//            int extraSpace = spaceCount % gaps;
//
//            for (int i = 0; i < words.size(); i++) {
//                line.append(words.get(i));
//                if (i < gaps) {
//                    for (int s = 0; s < evenSpace + (i < extraSpace ? 1 : 0); s++) {
//                        line.append(" ");
//                    }
//                }
//            }
//        }
//        System.out.println(line.toString());
//    }
//
//

}
