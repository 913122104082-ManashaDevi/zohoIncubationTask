public class day5PickAndPut {

        public static void main(String args[]) {
            int array[] = {2, 3, 5, 9, 13, 19, 21};
//            printFromItoJ(array, 6, 2);

            System.out.println("PickPut Test:");
            pickPut(array, 3, 6);
            System.out.println("----");
            pickPut(array, 6, 2);
        }

        public static void printFromItoJ(int array[], int start, int end) {
            int len;
            int n = array.length;
            if (start <= end){
                for (int i = start; i <=end; i++) {
                    System.out.print(array[i]+" ");
                }
            }
            else{
                for(int i = end; i <=start; i--) {
                    System.out.print(array[i]+" ");
                }
            }



        }

        public static void pickPut(int array[], int pick, int put) {
            int n = array.length;
            int element=array[pick];
            int move = pick < put ? 1 : -1;
            for (int i = pick; i != put; i += move)
            {
                    array[i] =+ array[i + move];
            }
            array[put] = element;
            for(int num:array)
                System.out.print(num+" ");
        }
    }

