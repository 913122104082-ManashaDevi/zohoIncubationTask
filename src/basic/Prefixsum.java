package basic;

import java.util.HashMap;

public class Prefixsum {

    public static int[] createPrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }
//    arr = {1, 2, 3, 4, 5}
//    queries = { {1, 3}, {0, 4}, {2, 2} }

    public static int[] rangeSumQueries(int[] arr, int[][] queries) {
        int[] prefix = createPrefixSum(arr);
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            if (L == 0)
                result[i] = prefix[R];
            else
                result[i] = prefix[R] - prefix[L - 1];
        }
        return result;
    }
    public static int subarraySumEqualsK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case
        int sum = 0, count = 0;

        for (int num : arr) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static int maxSubarraySum(int[] arr) {
        int max = arr[0], current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(max, current);
        }
        return max;
    }
    // left sum = right sum at i
    public static int pivotIndex(int[] nums) {
        int total = 0, leftSum = 0;
        for (int num : nums) total += num;

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }


}
