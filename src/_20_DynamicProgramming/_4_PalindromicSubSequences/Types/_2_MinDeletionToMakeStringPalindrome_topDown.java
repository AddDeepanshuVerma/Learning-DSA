package _20_DynamicProgramming._4_PalindromicSubSequences.Types;

public class _2_MinDeletionToMakeStringPalindrome_topDown {

    // Approach : find the longest palindromic subsequence present in the given string itself (rest character need to be deleted)
    public static int minDeletions(String[] args) {
        String str = "aebcbda";

        // step 1: find the longest common palindrome subsequence already present in string
        int len = LongestPalindromeSubseq(str);

        // step 2: rest character which are not included in LPS needs to be deleted
        return str.length() - len; // deletion
    }

    private static int LongestPalindromeSubseq(String str) {
        String s1 = str;
        String s2 = new StringBuilder(s1).reverse().toString();

        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
