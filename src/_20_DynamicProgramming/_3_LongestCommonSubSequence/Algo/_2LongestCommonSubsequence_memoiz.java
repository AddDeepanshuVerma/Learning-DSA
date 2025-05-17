package _20_DynamicProgramming._3_LongestCommonSubSequence.Algo;

import java.util.Arrays;

class _2LongestCommonSubsequence_memoiz {
    static int[][] dp;

    public int longestCommonSubsequence(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return solve(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    private int solve(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int res = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            res = 1 + solve(s1, s2, i - 1, j - 1);
        } else {
            res = Math.max(solve(s1, s2, i - 1, j), solve(s1, s2, i, j - 1));
        }
        return dp[i][j] = res;
    }


    //==============Below will be similar to TOP-DOWN tabular approach ==============
    public int longestCommonSubsequence2(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return solve2(s1, s2, s1.length(), s2.length());
    }

    private int solve2(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            res = 1 + solve2(s1, s2, i - 1, j - 1);
        } else {
            res = Math.max(solve2(s1, s2, i - 1, j), solve2(s1, s2, i, j - 1));
        }
        return dp[i][j] = res;
    }
}
