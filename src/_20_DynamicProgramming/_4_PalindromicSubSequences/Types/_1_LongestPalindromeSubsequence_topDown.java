package _20_DynamicProgramming._4_PalindromicSubSequences.Types;

public class _1_LongestPalindromeSubsequence_topDown {
    /*
     * A Subsequence which will be palindrome must be common in a string and reverse of that string
     * Approach : get the longest common subsequence bw string and its reverse.
     *   Longest palindromic subsequence of s === longest common subsequence bw s & reverse(s)
     * */
    public static void main(String[] args) {
        String s = "bbabcbcab";
        String lps = findLPS(s);
    }

    private static String findLPS(String str) {
        String s1 = str;
        String s2 = new StringBuilder(s1).reverse().toString();

        // step 1 : get the matrix form for lcs bw s1&s2
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
        // step 2 : now create that String out of matrix
        int i = m, j = n;
        StringBuilder lcss = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcss.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return lcss.toString();
    }
}
