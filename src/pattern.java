public class pattern
{
    public static void main(String[] args) {
         int n=5;
         int m=n*(n+1)/2;
         for(int i=n-1;i>=0;i--)
         {
             for(int j=1;j<=i;j++){
                 System.out.print(" ");
             }
             int ans=m-(i*(i+1)/2);
             System.out.print(ans+" ");
             for(int k=n-i-1;k<=n;k--);
             {

             }
         }}}



//}int left = 0, right = arr.length - 1;
//int index = 0;
//            while (left <= right) {
//        if (index % 2 == 0) {
//result[index++] = arr[right--];
//        } else {
//result[index++] = arr[left++];
//        }
//        }
//
//
//public static void AlternateSort() {
//    int[] arr =  {5, 2, 9, 1, 6, 3};
//    int min=0,max=0;
//    int n=arr.length;
//
//    for (int i = 0; i < n; i = i + 2) {
//        min=i;max=i;
//        for(int j=i+1;j<n;j++)
//        {    if(arr[min]>arr[j])
//            min=j;
//            if(arr[max]<arr[j])
//                max=j;
//        }
//        int temp= arr[i];
//        arr[i]=arr[max];
//        arr[max]=arr[i];
//        temp=arr[i+1];
//        arr[i+1]=arr[min];
//        arr[min]=arr[i+1];
//    }
//
//    for (int num : arr) {
//        System.out.print(num + " ");
//    }
//}
//
//
