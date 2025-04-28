package _20_DynamicProgramming._3_LongestCommonSubSequence.Algo;

public class _6LongestCommonSubString_topDown {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("ABCDGH", "ACDGHR"));
    }

    static int[][] dp;

    public static int longestCommonSubstr(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        dp = new int[m + 1][n + 1];
        // for base condition first row & first column need to be 0 answer as LCSub

        int max = 0;// answer may not come-up till bottom-right index but lies somewhere within matrix
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
