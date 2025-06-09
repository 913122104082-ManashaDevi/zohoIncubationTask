public class justifyMultiline {
public static void main(String args[]){

}
public static void justify(String input,int start,int end, int width) {
    int len = end-start+1;
    int spaceCount = 0;
    for (int i = start; i < start+len; i++) {
        if (input.charAt(i) == ' ') spaceCount++;
    }
    int extraSpaces = width - len;
    if (spaceCount == 0 || extraSpaces == 0) {
        System.out.println(input);
        return;
    }

    int evenSpace = extraSpaces / spaceCount;
    int extra = extraSpaces % spaceCount;
    int i = start;
    String spaces=" ".repeat(evenSpace);
    while (i < start+len)
    {
        char ch = input.charAt(i);
        System.out.print(ch);
        if(ch==' ')
        {
            System.out.print(spaces);
            if (extra > 0) {
                System.out.print(" ");
                extra--;
            }
        }
        i++;
    }

}
}
