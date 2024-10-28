package DailyCodeChallenge.Dynamic_Programming;

class MaximalSquare_221_2 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int max = 0;
        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 || j == 0) {
                    t[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1') {
                    t[i][j] = 1 + Math.min(t[i - 1][j - 1], Math.min(t[i - 1][j], t[i][j - 1]));
                } // else matrix[i][j] == '0' hence 0 should be store in tabulation matrix which as already the default value.

                max = Math.max(max, t[i][j]);
            }
        }
        return max * max;
    }
}