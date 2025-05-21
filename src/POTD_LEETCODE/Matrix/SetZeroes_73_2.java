package POTD_LEETCODE.Matrix;

import java.util.ArrayList;
import java.util.List;

class SetZeroes_73_2 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> zeros = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) zeros.add(new int[]{i, j});

        for (int[] zero : zeros) {
            int r = zero[0], c = zero[1];
            for (int col = 0; col < n; col++) matrix[r][col] = 0;
            for (int row = 0; row < m; row++) matrix[row][c] = 0;
        }
    }
}