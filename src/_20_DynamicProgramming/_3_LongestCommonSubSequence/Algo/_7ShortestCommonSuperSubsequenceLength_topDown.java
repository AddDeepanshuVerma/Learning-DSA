package _20_DynamicProgramming._3_LongestCommonSubSequence.Algo;

public class _7ShortestCommonSuperSubsequenceLength_topDown {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int SCSS = longestCommonSubsequence(s1, s2);
        // shortest common super sequence would be (s1 + s2 - scss)len;
        System.out.println(s1.length() + s2.length() - SCSS);
    }

    /*
     * Find length of the longest common Subsequence
     * which definitely will be common in the resultant string
     * Hence : the length of SCS would be = len of ( s1 + s2 ) - len of LCS
     * */
    private static int longestCommonSubsequence(String s1, String s2) {
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
