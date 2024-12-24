package _20_DynamicProgramming._4_PalindromicSubSequences.Types;

import java.util.Arrays;

public class _4_LongestRepeatingSubSequences_memo {
    // most unexpected change/variety in LongestCommonSubSequence which could not predict
    // here we are trying to get the LCS for str to str just making sure, we will count (1 + rest) only when indexes are not same
    public static int LongestRepeatingSubsequence() {
        String str = "AABCBDC";

        int m = str.length();
        int[][] dp = new int[m + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dfs(str, str, m, m, dp);
    }

    private static int dfs(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i != j && s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + dfs(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(dfs(s1, s2, i - 1, j, dp), dfs(s1, s2, i, j - 1, dp));
        }
    }

}
