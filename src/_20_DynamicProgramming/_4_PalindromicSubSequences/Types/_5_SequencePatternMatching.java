package _20_DynamicProgramming._4_PalindromicSubSequences.Types;

class _5_SequencePatternMatching {
    // Given two strings s and t, return true if s is a subsequence of t, or false otherwise
    /*
     * Approach : it can be easily done using two pointer tho, we'll do it with DP
     * In this approach we will check the longest common subsequence bw both & if our resultant lcs is equal to string s then
     * yes whole s is the subsequence of string t
     * */
    public boolean isSubsequence(String s, String t) {
        int lscLength = lcs(s, t);
        return lscLength == s.length();
    }

    private int lcs(String s, String t) {
        int m = s.length(), n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}