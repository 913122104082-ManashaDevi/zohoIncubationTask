import java.util.Scanner;

public class justifyMultiline {
public static void main(String args[]){
   Scanner sc=new Scanner(System.in) ;
   String input=sc.nextLine() ;
   int width=sc.nextInt();
   int n=input.length();
   System.out.println();
//   int i=0;
//   while(i<n){
//      int end=Math.min(i+width-1,n-1);
//      while(input.charAt(end)!=' '&& input.charAt(end+1)!=' ' ) end--;
//      justify(input, i,end,width);
//      i=end+1;
//      System.out.println();
//   }
    justify(input, 0,n-1,width);
}
public static void justify(String input,int start,int end, int width) {
    int len = end-start+1;
    int spaceCount = 0;
    for (int i = start; i < end; i++) {
        if (input.charAt(i) == ' ') spaceCount++;
    }
    int extraSpaces = width - len;
    if (spaceCount == 0 ) {
        System.out.println(input+" ".repeat(extraSpaces)+"|");
        return;
    }
    int evenSpace = extraSpaces / spaceCount;
    int extra = extraSpaces % spaceCount;
    String spaces=(" ").repeat(evenSpace-1);
    for(int i=0;i<len;i++){
        char ch = input.charAt(i+start);
        System.out.print(ch);
        if(ch==' ')
        {
            System.out.print(spaces);
            if (extra > 0) {
                System.out.print(" ");
                extra--;
            }
        }
    }

    }
}
