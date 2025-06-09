package basic;
public class SearchAlgorithms {

    // 1. Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }

    // 2. Binary Search (array must be sorted)
    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // 3. Jump Search (array must be sorted)
    public static int jumpSearch(int[] arr, int key) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) return -1;
        }

        while (arr[prev] < key) {
            prev++;
            if (prev == Math.min(step, n)) return -1;
        }

        return arr[prev] == key ? prev : -1;
    }

    // 4. Interpolation Search (for uniformly distributed sorted array)
    public static int interpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (low == high) {
                if (arr[low] == key) return low;
                return -1;
            }

            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == key)
                return pos;
            else if (arr[pos] < key)
                low = pos + 1;
            else
                high = pos - 1;
        }

        return -1;
    }

    // 5. Exponential Search (works on sorted array)
    public static int exponentialSearch(int[] arr, int key) {
        if (arr[0] == key) return 0;

        int i = 1;
        while (i < arr.length && arr[i] <= key)
            i *= 2;

        return binarySearchBetween(arr, i / 2, Math.min(i, arr.length - 1), key);
    }

    private static int binarySearchBetween(int[] arr, int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // 6. Ternary Search (works on sorted array)
    public static int ternarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (right >= left) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == key) return mid1;
            if (arr[mid2] == key) return mid2;

            if (key < arr[mid1])
                right = mid1 - 1;
            else if (key > arr[mid2])
                left = mid2 + 1;
            else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }

    // Main method to test all
    public static void main(String[] args) {
        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int key = 70;

        System.out.println("Linear Search: Index = " + linearSearch(sortedArray, key));
        System.out.println("Binary Search: Index = " + binarySearch(sortedArray, key));
        System.out.println("Jump Search: Index = " + jumpSearch(sortedArray, key));
        System.out.println("Interpolation Search: Index = " + interpolationSearch(sortedArray, key));
        System.out.println("Exponential Search: Index = " + exponentialSearch(sortedArray, key));
        System.out.println("Ternary Search: Index = " + ternarySearch(sortedArray, key));
    }
}
