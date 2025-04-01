package POTD_LEETCODE;

import java.util.Arrays;

class MostPoints_2140_2 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        Arrays.fill(dp, -1);
        return dfs(0, questions, dp);
    }

    private long dfs(int i, int[][] arr, long[] dp) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) return dp[i];

        long pick = arr[i][0] + dfs(i + 1 + arr[i][1], arr, dp);
        long skip = dfs(i + 1, arr, dp);

        return dp[i] = Math.max(skip, pick);
    }
}