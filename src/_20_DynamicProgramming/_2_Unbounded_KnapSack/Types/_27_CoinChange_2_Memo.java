package _20_DynamicProgramming._2_Unbounded_KnapSack.Types;

import java.util.Arrays;

// working fine
class _27_CoinChange_2_Memo {
    public static void main(String[] args) {
        int miniElements = count(new int[]{1, 2, 3}, 5);
        System.out.println(miniElements);
    }

    static int[][] dp;

    public static int count(int[] coins, int sum) {
        int index = 0;
        dp = new int[coins.length + 1][10001];
        for (int[] ints : dp) Arrays.fill(ints, -1);

        int ans = dfs(coins, index, sum);
        return ans == Integer.MAX_VALUE - 1 ? -1 : ans;
    }

    private static int dfs(int[] arr, int index, int sum) {
        if (index == arr.length || sum <= 0) {
            return sum == 0 ? 0 : Integer.MAX_VALUE - 1;
        }
        if (dp[index][sum] != -1) return dp[index][sum];

        int pick = 1 + dfs(arr, index, sum - arr[index]);
        int skip = dfs(arr, index + 1, sum);

        return dp[index][sum] = Math.min(pick, skip);
    }
}