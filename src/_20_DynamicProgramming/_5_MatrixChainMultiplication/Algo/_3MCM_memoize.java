package _20_DynamicProgramming._5_MatrixChainMultiplication.Algo;

import java.util.Arrays;

class _3MCM_memoize {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 20, 30};
//        int[] arr = {30, 20, 30};
        System.out.println(matrixMultiplication(arr));
    }

    static int matrixMultiplication(int[] arr) {
        int n = arr.length, i = 1, j = n - 1;
        int[][] dp = new int[n + 1][n + 1];
        Arrays.stream(dp).forEach(val -> Arrays.fill(val, -1));
        return dfs(i, j, arr, dp);
    }

    private static int dfs(int i, int j, int[] arr, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = dfs(i, k, arr, dp);
            int right = dfs(k + 1, j, arr, dp);
            int multiply = arr[i - 1] * arr[k] * arr[j];

            min = Math.min(min, left + right + multiply);
        }

        return dp[i][j] = min;
    }
}
