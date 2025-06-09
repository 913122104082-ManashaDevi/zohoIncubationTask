public class progressday23 {
//
//    public static void main(String[]args){
//        System.out.println("\nJustified Output:\n");
//        justifyText("i play cricket", 25);
//    }
//    public static void top3Frequeent(int[] array){
//        //input [7,7,3,3,3,11,6,9,11,3,7,3]
//        int len=array.length;
//        int max=array[0];
//        int frequency[]=new int[len];
//        int i=0;
//        for(int num:array){
//           i=0;
//          while(array[i]!=num)
//              i++;
//          frequency[i]++;
//        }
//        //frequency [3,0,5,0,0,0,2,1,1,0,0,0,0]  only with this concept
//        // top 3 elements find
//        int top1;
//        int top2;
//        int top3;
//        //find it with this logic
//    }
//    public static void minAlternate(int array){
//        int firstmin;
//        int secondmin;
//        // input[17,11,7,9,14,3,6]
//        // output [firstmin,thirdmin,.....fourthmin,secondmin]
//        // [3,7,11,17,14,9,6]
//           // optimized no extra array
//
//    }
//
//    public static void justifyText(String input, int width) {
//        // no extra arrat , no split ... use this logic crt it
//        int count=0;
//        int len=input.length();
//        for(int i=0;i<len;i++){
//            if(input.charAt(i)==' ')
//                count++;
//        }
//        int upToWhich=0;
//        int gap=0;
//        int spaceToBeAdded=width-len;
//        if(spaceToBeAdded==0)
//            System.out.println(input);
//        else{
//            gap=count/spaceToBeAdded;
//            upToWhich=count%spaceToBeAdded;
//        }
//        String spaces=" ".repeat(gap);
//        for(int i=0;i<len;i++){
//            char ch=input.charAt(i);
//            int space=0;
//            if(ch==' ')
//            {   space++;
//                if(space<=upToWhich)
//                    System.out.print(ch+" "+spaces);
//                else
//                    System.out.print(ch+spaces);
//            }
//            else
//                System.out.print(ch);
//        }
//
//    }
//
 }
