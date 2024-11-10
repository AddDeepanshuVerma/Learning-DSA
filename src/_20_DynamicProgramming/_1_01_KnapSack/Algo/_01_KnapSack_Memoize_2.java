package _20_DynamicProgramming._1_01_KnapSack.Algo;

import java.util.Arrays;

public class _01_KnapSack_Memoize_2 {
    static int[][] dp;

    public static void main(String[] args) {
        int[] val = {1, 3, 4, 51, 1, 3, 4, 51, 1, 3, 4, 51}; // value of item, index wise
        int[] wt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; // weight of item, index wise
        int W = 20; // capacity of knapsack

        dp = new int[val.length][W + 1];
        Arrays.stream(dp).forEach(ints -> Arrays.fill(ints, -1));
        int maxProfit = dfs(wt, val, W, 0);
        System.out.println("compact + Memoize = " + maxProfit);
    }


    // my understanding of solving the same using pick-notPick method
    private static int dfs(int[] wt, int[] val, int W, int idx) {
        if (idx == val.length || W == 0) return 0;
        if (dp[idx][W] != -1) return dp[idx][W];

        int opt = dfs(wt, val, W, idx + 1); // skip
        if (wt[idx] <= W) { // pick
            opt = Math.max(opt, val[idx] + dfs(wt, val, W - wt[idx], idx + 1));
        }

        return dp[idx][W] = opt;
    }
}
