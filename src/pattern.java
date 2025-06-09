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


