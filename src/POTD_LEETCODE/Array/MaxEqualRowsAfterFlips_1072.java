package POTD_LEETCODE.Array;

import java.util.HashMap;
import java.util.Map;

class MaxEqualRowsAfterFlips_1072 {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(maxEqualRowsAfterFlips2(matrix));
    }

    public static int maxEqualRowsAfterFlips2(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int item : row) {
                sb.append(row[0] == item ? "T" : "F");
            }
            count = Math.max(count, map.merge(sb.toString(), 1, Integer::sum));
        }
        return count;
    }
}