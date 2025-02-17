package _20_DynamicProgramming._3_LongestCommonSubSequence.Types;

import jdk.jfr.Description;

public class _10MinOperationsConvertStringAtoB_topDown {

    @Description("Minimum number of deletions and insertions to transform one string into another")
    public static void main(String[] args) {
        String a = "heap", b = "pea";
        /* Approach:
         * Intuition :  here we can say that we don't need to delete those sequence characters from string a that are common with string b
         *              And we need to add those which are extra in string b after removing common one
         * Approach : find the length of longest common subsequence bw string a & b
         *            deletion in a : length of a - lcs length
         *            Insertion in a: length of b - lcs length
         * */

        int lcs = lengthOfLongestCommonSubsequence(a, b);
        int deletion = a.length() - lcs;
        int insertion = b.length() - lcs;

        System.out.println("Min no of operations : " + deletion + insertion);
    }

    private static int lengthOfLongestCommonSubsequence(String s1, String s2) {
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

    // here we make the tabular matrix specific to this question only ( no need to learn tho as LCS should be referred for such questions
    private static int minNoOfOperations(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // only deletions will occur
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // only insertions will occur
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
