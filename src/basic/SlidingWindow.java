package basic;

import java.util.HashSet;


public class SlidingWindow {
    public static void main(String[] args){
        int arr[]={1,0,0,0,0,0,1,1,1};
        System.out.println( longestOnes(arr, 2));
    }

//Given an array and integer k, return the maximum sum of any subarray of size k.
    public static int maxSumKWindow(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;

        for (int i = 0; i < k; i++) windowSum += arr[i];
        maxSum = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
    public static int longestUniqueSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;
            if (k < 0) {
                if (nums[left] == 0) k++;
                left++;
            }
        }
        return nums.length - left;
    }

}
