package _20_DynamicProgramming._1_01_KnapSack.Algo;

public class _05_KnapSack_TopDown_2 {
    public static void main(String[] args) {
        int[] val = {1, 3, 4, 5}; // value of item, index wise
        int[] wt = {1, 2, 3, 4}; // weight of item, index wise
        int capacity = 5; // capacity of knapsack

        int n = val.length;

        int profit = maxProfit(n, capacity, wt, val);
        System.out.println("profit = " + profit);
    }

    // here we took dummy row for both val & capacity hence had to take (row+1, col+1)
    private static int maxProfit(int n, int capacity, int[] wt, int[] val) {
        // fill base case if val == 0 || capacity == 0 then profit is 0
        int[][] t = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                    continue;
                }

                int exclude = t[i - 1][j];
                int include = 0;
                if (wt[i - 1] <= j) {
                    include = val[i - 1] + t[i - 1][j - wt[i - 1]];
                }

                t[i][j] = Math.max(include, exclude);
            }
        }
        return t[n][capacity];
    }
}
