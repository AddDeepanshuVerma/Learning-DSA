package _20_DynamicProgramming._4_PalindromicSubSequences.Types;

public class _4_LongestRepeatingSubSequences_topDown {
    // most unexpected change/variety in LongestCommonSubSequence which could not predict
    // here we are trying to get the LCS for str to str just making sure, we will count (1 + rest) only when indexes are not same
    public static int LongestRepeatingSubsequence(String[] args) {
        String str = "AABCBDC";
        return lrs(str);
    }

    private static int lrs(String str) {
        String s1 = str, s2 = str;

        int m = s1.length();
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (i != j && s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][m];
    }
}
