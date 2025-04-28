package LeetCode_33Question_challenge_2025.week1;

import java.util.ArrayList;
import java.util.List;

public class Q7 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i, k = 0, l = 0;

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        while (k < m && l < n) {
            for (i = l; i < n; ++i) list.add(matrix[k][i]);
            k++;

            for (i = k; i < m; ++i) list.add(matrix[i][n - 1]);
            n--;

            if (k < m) {
                for (i = n - 1; i >= l; --i) list.add(matrix[m - 1][i]);
                m--;
            }

            if (l < n) {
                for (i = m - 1; i >= k; --i) list.add(matrix[i][l]);
                l++;
            }
        }

        return list;
    }
}
