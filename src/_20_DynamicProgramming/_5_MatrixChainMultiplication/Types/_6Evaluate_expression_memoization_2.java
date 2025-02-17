package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

import jdk.jfr.Description;

public class _6Evaluate_expression_memoization_2 {
    private static final int mod = 1000000007;

    @Description("After recursion applying memoization where we used the dp as of Long type : hence no need to assign -1 value as default in NULL")
    public static void main(String[] args) {
        String exp = "T|T&F^T";
        int n = exp.length();
        Long[][][] dp = new Long[n][n][2];

        int ans = (int) dfs(0, exp.length() - 1, exp, 1, dp);
        System.out.println(ans);
    }

    private static long dfs(int i, int j, String s, int isTrue, Long[][][] dp) {
        if (i > j) return 0;

        if (i == j) {
            char ch = s.charAt(i);
            return (isTrue == 1) ? ((ch == 'T') ? 1 : 0) : ((ch == 'F') ? 1 : 0);
        }

        if (dp[i][j][isTrue] != null) {
            return dp[i][j][isTrue];
        }

        long ways = 0;
        for (int k = i + 1; k < j; k += 2) {
            long LT = dfs(i, k - 1, s, 1, dp);
            long LF = dfs(i, k - 1, s, 0, dp);
            long RT = dfs(k + 1, j, s, 1, dp);
            long RF = dfs(k + 1, j, s, 0, dp);
            switch (s.charAt(k)) {
                case '|' -> {
                    if (isTrue == 1) ways = (ways + (LT * RF) % mod + (LF * RT) % mod + (LT * RT) % mod) % mod;
                    else ways = (ways + (LF * RF) % mod) % mod;
                }
                case '&' -> {
                    if (isTrue == 1) ways = (ways + (LT * RT) % mod) % mod;
                    else ways = (ways + (LT * RF) % mod + (LF * RT) % mod + (LF * RF) % mod) % mod;
                }
                case '^' -> {
                    if (isTrue == 1) ways = (ways + (LT * RF) % mod + (LF * RT) % mod) % mod;
                    else ways = (ways + (LT * RT) % mod + (LF * RF) % mod) % mod;
                }
            }
        }
        return dp[i][j][isTrue] = ways;
    }
}
