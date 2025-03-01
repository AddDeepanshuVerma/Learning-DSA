package Interesting;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class Callable_threading {
    public String shortestCommonSupersequence(String str1, String str2) {
        String res = "";
        try {
            Callable<String> task = () -> generateLCS(str1, str2);
            FutureTask<String> future = new FutureTask<>(task);
            new Thread(future).start();
            res = future.get();
        } catch (Exception ignored) {

        } // Wait for the thread to finish
        return res;
    }

    public String generateLCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int row = n;
        int col = m;

        String lcs = "";
        StringBuilder ans = new StringBuilder();
        while (row != 0 && col != 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                ans.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (dp[row - 1][col] > dp[row][col - 1]) {
                ans.append(str1.charAt(row - 1));
                row--;
            } else {
                ans.append(str2.charAt(col - 1));
                col--;
            }
        }

        for (int i = n - row; i < n; i++) {
            ans.append(str1.charAt(row - 1));
            row--;
        }

        for (int i = m - col; i < m; i++) {
            ans.append(str2.charAt(col - 1));
            col--;
        }

        return ans.reverse().toString();
    }
}