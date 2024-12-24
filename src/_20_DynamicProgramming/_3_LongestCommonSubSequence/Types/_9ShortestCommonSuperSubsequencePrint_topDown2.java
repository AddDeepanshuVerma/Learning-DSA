package _20_DynamicProgramming._3_LongestCommonSubSequence.Types;

public class _9ShortestCommonSuperSubsequencePrint_topDown2 {
    public static void main(String[] args) {
        String s1 = "AGGTAB", s2 = "GXTXAYB";

        String scss = shortestCommonSuperSequence(s1, s2);
        System.out.println("scss = " + scss);
    }

    public static String shortestCommonSuperSequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Build the DP table for Longest Common Subsequence (LCS)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Backtrack to construct the Shortest Common SuperSequence (SCS)
        StringBuilder ans = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s1.charAt(i - 1));
                i--;
            } else {
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters from either string
        while (i-- > 0) ans.append(s1.charAt(i - 1));
        while (j-- > 0) ans.append(s2.charAt(j - 1));

        // Step 3: Reverse the string since we built it backwards
        return ans.reverse().toString();
    }

}
