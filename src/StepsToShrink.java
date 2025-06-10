public class StepsToShrink {

        public static void main(String[] args) {
            int decimal = 12;
            int binary[] = intToBinary(decimal);
            int steps = calculateShrinkStep(binary[0], 1);
            System.out.println("Total steps: " + steps);
        }

    public static int[] intToBinary(int num)
    {
        int[] array=new int[2];
        int  place = 1;
        while (num > 0)
        {
            int rem = num % 2;
            array[0] += rem * place;
            place *= 10;
            num /= 2;
            array[1]++;
        }
        return array;
    }

        public static int calculateShrinkStep(int binary, int step) {
            if (binary == 10 || binary == 11) return step;
            int prev = -1, count = 0;
            int result = 0, place = 1;

            while (binary > 0)
            {
                int digit = binary % 10;
                binary /= 10;

                if (prev == -1) {
                    prev = digit;
                    count = 1;
                } else if (digit == prev) {
                    count++;
                } else {
                    int current[]=intToBinary(count);
                    result += current[0] * place;
                    place *= (int)Math.pow(10, current[1]);
                    prev = digit;
                    count = 1;
                }
            }
            int[] current=intToBinary(count);
            result += current[0] * place;
            return calculateShrinkStep(result, step + 1);
        }

    }






























































    // method decimal to binary 12 -> 1100 (input) ...
    //  method to caluculateShrinkStep
    // input 1100 now calculate continuous pattern count 2 1's 2'0  convert 2->10 2->10  number 1010
    // call recursuvily 1 '1s' 1 '0s' 1 '1s' 1 '0s'    convert 1->1 1->1 1->1 1->1 number 1111
    // call again untill its 11 or 10 ... while each recursive increment i return i atlast

