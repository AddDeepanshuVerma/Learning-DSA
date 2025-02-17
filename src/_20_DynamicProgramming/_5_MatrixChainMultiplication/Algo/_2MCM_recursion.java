package _20_DynamicProgramming._5_MatrixChainMultiplication.Algo;

public class _2MCM_recursion {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 20, 30};
        matrixMultiplication(arr);
    }

    static int matrixMultiplication(int arr[]) {
        int i = 1, j = arr.length - 1;
        return dfs(i, j, arr);
    }

    private static int dfs(int i, int j, int[] arr) {
        if (i >= j) {
            return 0; // even id the arr contains only single matrix (size:2) answer would be 0
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = dfs(i, k, arr), right = dfs(k + 1, j, arr);
            int multiply = arr[i - 1] * arr[k] * arr[j];

            min = Math.min(min, left + right + multiply);
        }
        return min;
    }
}
