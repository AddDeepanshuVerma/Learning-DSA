package _20_DynamicProgramming._3_LongestCommonSubSequence.Algo;

class _3LongestCommonSubsequence_topDown_print {
    static int[][] dp;

    public static void main(String[] args) {
        String s1 = "AGGTAB", s2 = "GXTXAYB";

        longestCommonSubsequence(s1, s2); // here we will get the matrix filled
        String lcs = GenerateTheString(s1, s2);
        System.out.println("lcs = " + lcs);
    }

    private static String GenerateTheString(String s1, String s2) {
        String lcs = "";
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs = s1.charAt(i - 1) + lcs;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[j - 1][i]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return lcs;
    }

    public static void longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

}
