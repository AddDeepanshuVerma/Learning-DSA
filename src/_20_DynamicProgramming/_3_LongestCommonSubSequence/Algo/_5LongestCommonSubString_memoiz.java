package _20_DynamicProgramming._3_LongestCommonSubSequence.Algo;

import java.util.Arrays;

public class _5LongestCommonSubString_memoiz {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("ABCDGH", "ACDGHR"));
    }

    static int max;
    static int[][] dp;

    public static int longestCommonSubstr(String s1, String s2) {
        max = 0;
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        solve(s1, s2, s1.length(), s2.length());
        return max;
    }

    private static int solve(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            ans = 1 + solve(s1, s2, i - 1, j - 1);
        } else {
            ans = 0;
        }

        solve(s1, s2, i - 1, j);
        solve(s1, s2, i, j - 1);

        max = Math.max(ans, max);
        return dp[i][j] = ans;
    }
}
