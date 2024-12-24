package _20_DynamicProgramming._3_LongestCommonSubSequence.Types;

import java.util.Arrays;

public class _8ShortestCommonSuperSubsequencePrint_memoiz {
    public static void main(String[] args) {
        String s1 = "AGGTAB", s2 = "GXTXAYB";

        String scss = shortestCommonSuperSequence(s1, s2);
        System.out.println("scss = " + scss);
    }

    public static String shortestCommonSuperSequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int len = lcs(str1, str2, m, n, dp);
        return superSeq(str1, str2, dp);
    }

    public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j - 1, dp));
        }
    }

    public static String superSeq(String s1, String s2, int[][] dp) {
        int i = s1.length(), j = s2.length();
        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
            } else {
                lcs.insert(0, s2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            lcs.insert(0, s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            lcs.insert(0, s2.charAt(j - 1));
            j--;
        }
        return lcs.toString();
    }

}
