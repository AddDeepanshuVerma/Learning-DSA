package DailyCodeChallenge.Dynamic_Programming;

import jdk.jfr.Description;

@Description("Advanced bottom-up approach")
class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int max = 0;

        int[][] dp = new int[r + 1][c + 1]; // added one more row and will evaluate till <= m && <= n

        for (int i = 1; i <= r; i++)
            for (int j = 1; j <= c; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;
                dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                max = Math.max(max, dp[i][j]);
            }
        return max * max;
    }
}