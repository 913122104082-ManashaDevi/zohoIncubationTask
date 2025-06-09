package basic;

public class dp {
    // 1. Recursion
    public static int climbRec(int n) {
        if (n <= 2) return n;
        return climbRec(n - 1) + climbRec(n - 2);
    }

    // 2. Memoization
    public static int climbMemo(int n, int[] dp) {
        if (n <= 2) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = climbMemo(n - 1, dp) + climbMemo(n - 2, dp);
    }

    // 3. Tabulation
    public static int climbTab(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // 4. Space Optimization
    public static int climbSpace(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    // House Robber / Max Sum Non-Adjacent
    // 1. Recursion
    public static int robRec(int[] arr, int n) {
        if (n < 0) return 0;
        if (n == 0) return arr[0];
        return Math.max(robRec(arr, n - 1), robRec(arr, n - 2) + arr[n]);
    }

    // 2. Memoization
    public static int robMemo(int[] arr, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return arr[0];
        if (dp[n] != -1) return dp[n];
        return dp[n] = Math.max(robMemo(arr, n - 1, dp), robMemo(arr, n - 2, dp) + arr[n]);
    }

    // 3. Tabulation
    public static int robTab(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);

        return dp[n - 1];
    }

    // 4. Space Optimization
    public static int robSpace(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        int prev1 = arr[0], prev2 = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev2, prev1 + arr[i]);
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
    //kanpsack
    // 1. Recursion
    public static int knapRec(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) return 0;
        if (wt[n - 1] <= W)
            return Math.max(val[n - 1] + knapRec(wt, val, W - wt[n - 1], n - 1),
                    knapRec(wt, val, W, n - 1));
        else
            return knapRec(wt, val, W, n - 1);
    }

    // 2. Memoization
    public static int knapMemo(int[] wt, int[] val, int W, int n, int[][] dp) {
        if (n == 0 || W == 0) return 0;
        if (dp[n][W] != -1) return dp[n][W];
        if (wt[n - 1] <= W)
            return dp[n][W] = Math.max(val[n - 1] + knapMemo(wt, val, W - wt[n - 1], n - 1, dp),
                    knapMemo(wt, val, W, n - 1, dp));
        else
            return dp[n][W] = knapMemo(wt, val, W, n - 1, dp);
    }

    // 3. Tabulation
    public static int knapTab(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    // 4. Space Optimization (2 Rows)
    public static int knapSpace(int[] wt, int[] val, int W, int n) {
        int[] prev = new int[W + 1];
        int[] curr = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                if (wt[i] <= w)
                    curr[w] = Math.max(val[i] + prev[w - wt[i]], prev[w]);
                else
                    curr[w] = prev[w];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[W];
    }

}
