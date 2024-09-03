package Interesting;

import java.util.Arrays;

class StoneGameII_1140_2 {
    int[][][] dp;

    public int stoneGameII(int[] piles) {
        int alice = 1;
        int index = 0;
        int M = 1;
        dp = new int[2][101][101];
        for (int[][] _2d : dp) {
            Arrays.stream(_2d).forEach(_1d -> Arrays.fill(_1d, -1));
        }
        return solve(piles, alice, index, M);
    }

    private int solve(int[] arr, int alice, int index, int M) {
        int n = arr.length;
        if (index >= n) return 0;
        if (dp[alice][index][M] != -1) return dp[alice][index][M];

        int result = alice == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i <= Math.min(2 * M, n - index); i++) {
            sum += arr[i + index - 1];
            int temp;
//           Imagine it like this: On Alice's turn, he would like to maximize his result.
//           And on Bob's turn, he would like to maximize his result or minimize Alice's result.
            if (alice == 1) {
                temp = sum + solve(arr, 0, i + index, Math.max(M, i));
                result = Math.max(result, temp);
            } else {
                temp = solve(arr, 1, i + index, Math.max(M, i));
                result = Math.min(result, temp);
            }
        }
        return dp[alice][index][M] = result;
    }
}