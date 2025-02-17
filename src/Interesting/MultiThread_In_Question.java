package Interesting;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MultiThread_In_Question {

    public static int longestCommonSubsequence(String text1, String text2) {
        int res = 0;
        try {
            Callable<Integer> task = () -> solve(text1, text2);
            FutureTask<Integer> future = new FutureTask<>(task);
            new Thread(future).start();
            res = future.get();
        } catch (Exception ignored) {

        } // Wait for the thread to finish
        return res;
    }

    public static int solve(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}