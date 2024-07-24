package DailyCodeChallenge;

import java.util.Arrays;

class RestoreMatrix_1605 {
    public static void main(String[] args) {
        int[] rowSum = {5, 7, 10};
        int[] colSum = {8, 6, 8};
        System.out.println(Arrays.deepToString(restoreMatrix(rowSum, colSum)));
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                res[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return res;
    }
}