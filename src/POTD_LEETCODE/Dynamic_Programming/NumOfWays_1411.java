package POTD_LEETCODE.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumOfWays_1411 {
    final int MOD = (int) (1e9 + 7);
    private int[][] dp;
    static List<String> combination = new ArrayList<>();


    static {
        allCombination(0, '#', "");
    }

    public int numOfWays(int n) {
        dp = new int[combination.size()][n];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        int ways = 0;
        for (int i = 0; i < combination.size(); i++) {
            ways = (ways + dfs(i, n - 1)) % MOD;
        }
        return ways;
    }

    private int dfs(int prev, int remaining) {
        if (remaining == 0) return 1;
        if (dp[prev][remaining] != -1) return dp[prev][remaining];

        int ways = 0;
        for (int i = 0; i < combination.size(); i++) {
            if (i == prev || isSame(prev, i)) continue;
            ways = (ways + dfs(i, remaining - 1)) % MOD;
        }
        return dp[prev][remaining] = ways;
    }

    private boolean isSame(int i, int j) {
        String s1 = combination.get(i);
        String s2 = combination.get(j);
        for (int k = 0; k < s1.length(); k++) {
            if (s1.charAt(k) == s2.charAt(k)) {
                return true;
            }
        }
        return false;
    }

    private static void allCombination(int filled, char prev, String curr) {
        if (filled == 3) {
            combination.add(curr);
            return;
        }

        for (char ch : new char[]{'R', 'G', 'B'}) {
            if (ch == prev) continue;
            allCombination(filled + 1, ch, curr + ch);
        }
    }
}