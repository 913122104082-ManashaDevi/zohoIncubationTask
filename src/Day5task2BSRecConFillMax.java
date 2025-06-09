public class Day5task2BSRecConFillMax {
    public static  void main(String args[]){
//       int rect1[][]={{1,3},{1,4},{2,3},{2,4}} ;
//       int rect2[][]={{1,3},{1,4},{2,3},{2,4}} ;
//       System.out.println(rectangleConflict(rect1,rect2)? "conflict": "not conflict");
//       int rect3[][]={{1,3},{1,4},{2,3},{2,4}} ;
//       int rect4[][]={{1,3},{1,4},{4,3},{4,4}} ;
//       System.out.println(rectangleConflict(rect3,rect4)? "conflict": "not conflict");
//        int rect3[][]={{1,3},{1,4},{2,3},{2,4}} ;
//        int rect4[][]={{3,3},{3,4},{4,3},{4,4}} ;
//        System.out.println(rectangleConflict(rect3,rect4)? "conflict": "not conflict");
       // fillMax(new int[]{11,3,31,5,17,4});
       // binarySearch(new int[]{1,3,4,5,6,7,8},2);

        compressInteger(12345678);
    }
    public static void binarySearch(int array[], int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                System.out.println(array[mid] + " at index " + mid);
                return;
            }
            if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        if (mid > 0 && mid < array.length - 1) {
            int leftDiff = Math.abs(target - array[mid - 1]);
            int rightDiff = Math.abs(array[mid + 1] - target);
            if (leftDiff < rightDiff)
                System.out.println(target + " not found, closest " + array[mid - 1]);
            else
                System.out.println(target + " not found, closest " + array[mid + 1]);
        } else if (mid == 0) {
            System.out.println(target + " not found, closest " + array[0]);
        } else {
            System.out.println(target + " not found, closest " + array[array.length - 1]);
        }
    }


    public static boolean rectangleConflict(int[][] array1, int[][] array2) {
            int[] bounds1 = findBoundary(array1);
            int[] bounds2 = findBoundary(array2);
            int leftA = bounds1[0], bottomA = bounds1[1], rightA = bounds1[2], topA = bounds1[3];
            int leftB = bounds2[0], bottomB = bounds2[1], rightB = bounds2[2], topB = bounds2[3];
            if(rightA <= leftB || rightB <= leftA || topA <= bottomB || topB <= bottomA) {
                return false;
            }
            return true;
        }
        private static int[] findBoundary(int[][] rect) {
            int minX = rect[0][0], minY = rect[0][1];
            int maxX = rect[0][0], maxY = rect[0][1];
            for (int i = 1; i < 4; i++) {
                minX = Math.min(minX, rect[i][0]);
                maxX = Math.max(maxX, rect[i][0]);
                minY = Math.min(minY, rect[i][1]);
                maxY = Math.max(maxY, rect[i][1]);
            }
            return new int[]{minX, minY, maxX, maxY};
        }

        public static void fillMax(int array[]){
          int n=array.length;
          int currentMax=array[n-1];
          for(int i=n-2;i>=0;i--)
          {
              if(array[i]>currentMax)
                  currentMax=array[i];
              else
                  array[i]=-1;
          }
          for(int num:array)
              System.out.print(num+" ");
        }

        public static void compressInteger(int value){
        // 2342  1 2's 1 3's  1 4's 1 2's
            // 33342  3 3's  1 4's 1 2's
        int pos=countPosDigits(value);
        int currentDigit=0;
        if(value<=9)
            System.out.println("1"+value);
        int lastDigit=value/pos;
        int countSame=1;
        value=value%pos;
        pos=pos/10;
        while(value>0){
           currentDigit=value/pos;
           value=value%pos;
           pos=pos/10;
           if(currentDigit==lastDigit){
               countSame++;
           }else{
               lastDigit=currentDigit;
               System.out.print(countSame+""+lastDigit);
           }

        }
        if(currentDigit==lastDigit)
            System.out.print(countSame+""+lastDigit);
        }
        public static int countPosDigits(int value){
        int pos=1;
        if(value<=9)
            return pos;
        while(value>9){
            value=value/10;
            pos=pos*10;
        }
        return pos;
        }



}
