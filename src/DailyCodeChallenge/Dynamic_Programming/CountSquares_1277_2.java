package DailyCodeChallenge.Dynamic_Programming;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("Added memo in recursion which make it a DP")
class CountSquares_1277_2 {
    int m, n;
    int[][] dp;

    public int countSquares(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int result = 0;

        dp = new int[m + 1][n + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    result += solve(i, j, matrix);
                }
            }
        }
        return result;
    }

    private int solve(int i, int j, int[][] matrix) {
        if (i >= m || j >= n) return 0;
        if (matrix[i][j] == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int right = solve(i, j + 1, matrix);
        int diago = solve(i + 1, j + 1, matrix);
        int below = solve(i + 1, j, matrix);

        return dp[i][j] = 1 + Math.min(diago, Math.min(right, below));
    }
}