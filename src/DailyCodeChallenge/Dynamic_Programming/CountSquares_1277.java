package DailyCodeChallenge.Dynamic_Programming;

import jdk.jfr.Description;

@Description("Simple recursion (memo can be applied as we are calculating the same this again and again")
class CountSquares_1277 {
    int m, n;

    public int countSquares(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int result = 0;

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

        int right = solve(i, j + 1, matrix);
        int diago = solve(i + 1, j + 1, matrix);
        int below = solve(i + 1, j, matrix);

        return 1 + Math.min(diago, Math.min(right, below));
    }
}