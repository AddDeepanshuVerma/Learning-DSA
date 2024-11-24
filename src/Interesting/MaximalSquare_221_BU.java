package Interesting;

import javax.xml.transform.Result;

// Bottom up approach
class MaximalSquare_221_BU {
    int m, n;
    int[][] t;

    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int max = 0;
        t = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1') {
                    t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i - 1][j], t[i][j - 1]));
                }
                max = Math.max(max, t[i][j]);
            }
        }
        return max * max;
    }
}