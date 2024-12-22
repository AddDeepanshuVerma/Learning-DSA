package _20_DynamicProgramming._3_LongestCommonSubSequence.Algo;

import java.util.Arrays;

class _3LongestCommonSubsequence_topDown {
    static int[][] dp;

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

    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // here col represent the length of s1 used so far & here row represent the length of s2 used so far

        // hence when s1 == 0 for first row, max LCS will be 0
        // similar when s2 == 0 for first col, max LCS will be 0

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
