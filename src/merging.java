public class merging {
        private static int k = 0;
        public static void merge(int[] array1, int[] array2) {
            int n = array1.length, m = array2.length;
            int[] merged = new int[n + m];

            int start1 = 0,end1 = n;
            int start2 = 0,end2 = m;
            int step1 = 1, step2 = 1;

            if(array1[0] > array1[n - 1]){
                start1=n-1;
                end1=-1;
                step1=-1;
            }

            if(array2[0] > array2[n - 1]){
                start2=m-1;
                end2=-1;
                step2=-1;
            }

            while (start1!=end1 && start2!=end2) {
                if (array1[start1] <= array2[start2]) {
                    merged[k++] = array1[start1];
                    start1 += step1;
                } else {
                    merged[k++] = array2[start2];
                    start2 += step2;
                }
            }
            adder(start1,end1,step1,array1,merged);
            adder(start2,end2,step2,array2,merged);
            System.out.print("Merged Array: [");
            for (int i=0;i<k-1 ;i++) {
                System.out.print(merged[i] + ",");
            }
            System.out.print(merged[k-1]+"]");
        }
    private static void adder(int start, int end, int step, int[] array, int[] merged) {
            while(start!=end){
               merged[k++]=array[start];
               start+=step;
            }
    }

    public static void main(String[] args) {
            int[] array1 = {9, 6, 3};
            int[] array2 = {1, 5, 7};
            merge(array1, array2);
        }

    }


