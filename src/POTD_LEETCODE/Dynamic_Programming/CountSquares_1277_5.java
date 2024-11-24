package POTD_LEETCODE.Dynamic_Programming;

import jdk.jfr.Description;

@Description("BEST APPROACH :: Advanced bottom-up approach")
class CountSquares_1277_5 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int result = 0;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == 0) continue;
                dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                result += dp[i][j];
            }
        return result;
    }
}