package _20_DynamicProgramming._1_01_KnapSack.Algo;

import java.util.Arrays;

public class _02_KnapSack_Memoize {
    static int[][] dp;

    public static void main(String[] args) {
        int[] val = {1, 3, 4, 51, 1, 3, 4, 51, 1, 3, 4, 51}; // value of item, index wise
        int[] wt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; // weight of item, index wise
        int W = 20; // capacity of knapsack
        System.out.println("correct ans    = " + correct(wt, val, W, val.length));

        dp = new int[val.length + 1][W + 1];
        Arrays.stream(dp).forEach(ints -> Arrays.fill(ints, -1));

        int maxProfit = knapSack(wt, val, W, val.length);
        System.out.println("Aditya Memoize = " + maxProfit);

        Arrays.stream(dp).forEach(ints -> Arrays.fill(ints, -1));
        int maxProfit2 = dfs(wt, val, W, 0);
        System.out.println("mine Memoize   = " + maxProfit2);
    }

    // Aditya's way of solving this problem
    private static int knapSack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) return 0;

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        int currWt = wt[n - 1];
        if (currWt <= W) { // current weight has a chance to get included or not
            return dp[n][W] = Math.max(val[n - 1] + knapSack(wt, val, W - currWt, n - 1),
                                                    knapSack(wt, val, W, n - 1));
        } else { // we are not including the current wight
            return dp[n][W] = knapSack(wt, val, W, n - 1);
        }
    }

    // my understanding of solving the same using pick-notPick method
    private static int dfs(int[] wt, int[] val, int W, int idx) {
        if (idx == val.length || W == 0) return 0;

        if (dp[idx][W] != -1) {
            return dp[idx][W];
        }

        int include = 0, exclude = 0;
        if (wt[idx] <= W) { // pick
            include = val[idx] + dfs(wt, val, W - wt[idx], idx + 1);
        }
        exclude = dfs(wt, val, W, idx + 1); // notPick

        return dp[idx][W] = Math.max(exclude, include);
    }

    private static int correct(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        int currWt = wt[n - 1];
        if (currWt <= W) { // current weight has a chance to get included or not
            return Math.max(val[n - 1] + correct(wt, val, W - currWt, n - 1), correct(wt, val, W, n - 1));
        } else { // we are not including the current wight
            return correct(wt, val, W, n - 1);
        }
    }
}
