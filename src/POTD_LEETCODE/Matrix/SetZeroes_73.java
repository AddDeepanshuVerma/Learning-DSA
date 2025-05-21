package POTD_LEETCODE.Matrix;

import java.util.ArrayList;
import java.util.List;

class SetZeroes_73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> zeros = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) zeros.add(new int[]{i, j});

        for (int[] zero : zeros) {
            markZero2(zero[0], zero[1], m, n, matrix);
        }
    }

    private void markZero2(int r, int c, int m, int n, int[][] matrix) {
        for (int col = 0; col < n; col++) matrix[r][col] = 0;

        for (int row = 0; row < m; row++) matrix[row][c] = 0;
    }

    private void markZero(int r, int c, int m, int n, int[][] matrix, int[][] dirs) {
        if (r < 0 || r >= m || c < 0 || c >= n) return;
        matrix[r][c] = 0;
        for (int[] dir : dirs) {
            int r_ = r + dir[0];
            int c_ = c + dir[1];
            markZero(r_, c_, m, n, matrix, dirs);
        }
    }

}