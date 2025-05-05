package POTD_LEETCODE.Recursion;

import java.util.Arrays;

// Works fine as repeated statements has been removed :: Recursion + Memoization + MOD !== TLE
class NumTilings_790_3 {
    static int[][] dp;
    final static int MOD = (int) 1e9 + 7;

    public static int numTilings(int n) {
        int firstRow = 0, secondRow = 0;
        dp = new int[n + 1][n + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return dfs(firstRow, secondRow, n);
    }

    private static int dfs(int x, int y, int n) {
        if (x > n || y > n) return 0;
        if (x == n && y == n) return 1;

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int count = 0;

        if (x == y) {
            count = (count + dfs(x + 1, y + 1, n)) % MOD;       // add |
            count = (count + dfs(x + 2, y + 2, n)) % MOD;       // add =
            count = (count + dfs(x + 1, y + 2, n)) % MOD;       // add L
            count = (count + dfs(x + 2, y + 1, n)) % MOD;       // add |-
        } else if (x < y) {
            count = (count + dfs(x + 2, y, n)) % MOD;              // add -
            count = (count + dfs(x + 2, y + 1, n)) % MOD;       // add _|
        } else {
            count = (count + dfs(x, y + 2, n)) % MOD;              // add _
            count = (count + dfs(x + 1, y + 2, n)) % MOD;       // add _|
        }

        return dp[x][y] = count;
    }


    public static void main(String[] args) {
        int ans = numTilings(30);
        System.out.println("ans = " + ans);

    }
}