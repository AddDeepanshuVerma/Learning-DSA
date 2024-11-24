package _20_DynamicProgramming._1_01_KnapSack.Algo;

public class _01_KnapSack_Recursive {
    public static void main(String[] args) {
        int[] val = {1, 3, 4, 51}; // value of item, index wise
        int[] wt = {1, 4, 5, 7}; // weight of item, index wise
        int W = 4; // capacity of knapsack
        int maxProfit = knapSack(wt, val, W, val.length);
        System.out.println("maxProfit = " + maxProfit);

        int maxProfit2 = dfs(wt, val, W, 0);
        System.out.println("maxProfit2 = " + maxProfit2);
    }

    // Aditya's way of solving this problem
    private static int knapSack(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) return 0;

        if (wt[n - 1] <= W) { // current weight has a chance to get included or not
            return Math.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1),
                                         knapSack(wt, val, W, n - 1));
        } else { // we are not including the current wight
            return knapSack(wt, val, W, n - 1);
        }
    }

    // my understanding of solving the same using pick-skip method
    private static int dfs(int[] wt, int[] val, int W, int idx) {
        if (idx == val.length || W == 0) return 0;

        int pick = 0, skip = 0;
        if (wt[idx] <= W) { // pick
            pick = val[idx] + dfs(wt, val, W - wt[idx], idx + 1);
        }
        skip = dfs(wt, val, W, idx + 1); // skip

        return Math.max(skip, pick);
    }
}
