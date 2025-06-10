public class RoatedArrayBinarySearch {

    public static void main(String[] args) {
        int[] array1 = {3,4,5,1,2};
        int[] array2 = {4,5,1,2,3};

        System.out.println(search(array1,0,array1.length-1, 1));
        System.out.println(search(array2, 0,array2.length-1,2));
        System.out.println(search(array2, 0,array2.length-1,6));
    }

    private static int search(int[] arr,int left,int right, int key)
    {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == key)
            return mid;
        else if (arr[left] <= arr[mid])
            return leftSorted(arr,left,right,mid,key);
        else
            return rightSorted(arr,left,right,mid,key);
    }
    public static int leftSorted(int arr[],int left,int right,int mid,int key)
    {
        if ( arr[left]<=key && key < arr[mid])
            return search(arr, left,mid-1, key);
        else
            return search(arr, mid+1,right, key);
    }
    public static int rightSorted(int arr[],int left,int right,int mid,int key)
    {
        if ( arr[mid]< key && key <= arr[right])
            return search(arr, mid+1,right, key);
        else
            return search(arr, left,mid-1, key);
    }
}

