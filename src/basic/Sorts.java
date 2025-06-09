package basic;

public class Sorts {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the index of the minimum element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap with the first element of the unsorted part
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void mergeSortInPlace(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortInPlace(arr, left, mid);
            mergeSortInPlace(arr, mid + 1, right);
            mergeInPlace(arr, left, mid, right);
        }
    }

    public static void mergeInPlace(int[] arr, int l, int m, int r) {
        int start1 = l, start2 = m + 1;

        // If the direct merge is already sorted
        if (arr[m] <= arr[start2]) {
            return;
        }

        // Two pointers to maintain start of both arrays
        while (start1 <= m && start2 <= r) {
            if (arr[start1] <= arr[start2]) {
                start1++;
            } else {
                int value = arr[start2];
                int index = start2;

                // Shift all elements between start1 and start2 to right by 1
                while (index != start1) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start1] = value;

                // Update all pointers
                start1++;
                m++;
                start2++;
            }
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
