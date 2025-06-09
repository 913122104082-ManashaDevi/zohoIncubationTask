public class day5PrintFromi2j {
    public static void main(String args[]){
        int array[]={2,3,5,9,13,19,21};
        printing(array,6,3);
    }
//    public static void printFromItoJ(int array[],int start, int end)
//    {  int len=0;
//        int n=array.length;
//       if(start<end)
//           len=end-start;
//       else
//           len= n-end+start+1;
//       for(int i=start;i<=start+len;i++){
//           System.out.println(array[i%n]);
//       }
//    }
    public static void printing(int array[],int from,int to)
    {
       int start=from;
       int end=to;
       int step=from<to?1:-1;
       for(int i=start;i!=end+step;i+=step){
           System.out.println(array[i]);
       }
    }
}
