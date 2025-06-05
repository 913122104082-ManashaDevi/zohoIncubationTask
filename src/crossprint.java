public class crossprint {
        public static void main(String[] args) {
            int n=6;
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++) {
                    if(i%2==1)
                         System.out.printf("%4d", ((i - 1) * n + j ));
                    else
                         System.out.printf("%4d", ((i - 1) * n + (n-j+1) ));

                }
                System.out.println();
            }

        }

    public static void apgp(int a, int d, int n)
    {
        int start = a;
        for (int i = 0; i < n; i++)
            System.out.print(start + (d * i) + " ");
        System.out.println();

        start = a;
        System.out.print(start + " ");

        for (int i = 1; i < n; i++)
        {
            start = start * d;
            System.out.print(start + " ");
        }
    }



}

