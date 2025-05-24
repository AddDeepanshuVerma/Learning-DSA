package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ColorTheGrid_1931 {
    final int MOD = (int) (1e9 + 7);
    private List<String> all;
    private int[][] dp;

    public int colorTheGrid(int m, int n) {
        // calculate all valid possible masks to be put in each column
        all = new ArrayList<>();
        solve('#', "", m);
        System.out.println("all = " + all);

        // now calculate how many those bit mack can be synced to fill n columns
        dp = new int[all.size() + 2][n + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return dfs(-1, 0, n, m);
    }

    private int dfs(int prev, int filledCol, int col, int m) {
        if (filledCol == col) return 1;

        if (dp[prev + 1][filledCol] != -1) {
            return dp[prev + 1][filledCol];
        }
        int ways = 0;
        if (prev == -1) {
            for (int i = 0; i < all.size(); i++) {
                ways = (ways + dfs(i, filledCol + 1, col, m)) % MOD;
            }
        } else {
            for (int i = 0; i < all.size(); i++) {
                if (isSame(prev, i, m)) continue;
                ways = (ways + dfs(i, filledCol + 1, col, m)) % MOD;
            }
        }
        return dp[prev + 1][filledCol] = ways;
    }

    private boolean isSame(int i, int j, int m) {
        for (int k = 0; k < m; k++) {
            if (all.get(i).charAt(k) == all.get(j).charAt(k)) return true;
        }
        return false;
    }

    private void solve(char prev, String curr, int m) {
        if (curr.length() == m) {
            all.add(curr);
        } else {
            for (char ch : new char[]{'R', 'G', 'B'}) {
                if (ch == prev) continue;
                solve(ch, curr + ch, m);
            }
        }
    }

    public static void main(String[] args) {
        var obj = new ColorTheGrid_1931();
        int ways = obj.colorTheGrid(5, 5);
        System.out.println("ways = " + ways);
    }
}