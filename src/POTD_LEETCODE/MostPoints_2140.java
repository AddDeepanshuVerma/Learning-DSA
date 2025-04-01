package POTD_LEETCODE;

import java.util.Arrays;

class MostPoints_2140 {

    private long[] dp;

    public long mostPoints(int[][] questions) {
        dp = new long[questions.length + 1];
        Arrays.fill(dp, -1);
        return dfs(0, questions);
    }

    private long dfs(int i, int[][] arr) {
        if (i >= arr.length) return 0;
        if (dp[i] != -1) {
            return dp[i];
        }

        long pick = arr[i][0] + dfs(i + 1 + arr[i][1], arr);
        long skip = dfs(i + 1, arr);

        return dp[i] = Math.max(skip, pick);
    }
}