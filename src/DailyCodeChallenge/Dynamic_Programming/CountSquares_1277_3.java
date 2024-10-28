package DailyCodeChallenge.Dynamic_Programming;

import jdk.jfr.Description;

@Description("DP to bottom-up approach")
class CountSquares_1277_3 {
    int m, n;
    int[][] dp;

    public int countSquares(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int result = 0;

        dp = new int[m + 1][n + 1]; // all dp elements already with 0

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || j == 0) { // base case all other cases depends on it
                    dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                } // else matrix itself was 0 at this index hence 0 is added

                result += dp[i][j];
            }
        }
        return result;
    }

    public int countSquares2(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int result = 0;

        dp = new int[m + 1][n + 1]; // all dp elements already with 0

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) { // base case all other cases depends on it
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }
                }
                result += dp[i][j];
            }
        }
        return result;
    }
}