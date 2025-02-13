package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

import jdk.jfr.Description;

import java.util.Arrays;

public class _5Evaluate_expression_memoization {
    private static final int mod = 1000000007;

    @Description("After recursion applying memoization where we used the dp as of int type")
    public static void main(String[] args) {
        String exp = "T|T&F^T";
        int n = exp.length();
        int[][][] dp = new int[n][n][2];
        for (int[][] ints : dp) for (int[] anInt : ints) Arrays.fill(anInt, -1);

        int ans = dfs(0, n - 1, exp, 1, dp);
        System.out.println(ans);
    }

    private static int dfs(int i, int j, String s, int isTrue, int[][][] dp) {
        if (i > j) return 0;

        if (i == j) {
            char ch = s.charAt(i);
            return (isTrue == 1) ? ((ch == 'T') ? 1 : 0) : ((ch == 'F') ? 1 : 0);
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        int ways = 0;
        for (int k = i + 1; k < j; k += 2) {
            int leftTrue = dfs(i, k - 1, s, 1, dp);
            int leftFalse = dfs(i, k - 1, s, 0, dp);
            int rightTrue = dfs(k + 1, j, s, 1, dp);
            int rightFalse = dfs(k + 1, j, s, 0, dp);
            switch (s.charAt(k)) {
                case '|':
                    if (isTrue == 1) ways = (ways + (leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod + (leftTrue * rightTrue) % mod) % mod;
                    else ways = (ways + (leftFalse * rightFalse) % mod) % mod;
                    break;
                case '&':
                    if (isTrue == 1) ways = (ways + (leftTrue * rightTrue) % mod) % mod;
                    else ways = (ways + (leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod + (leftFalse * rightFalse) % mod) % mod;
                    break;
                case '^':
                    if (isTrue == 1) ways = (ways + (leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod) % mod;
                    else ways = (ways + (leftTrue * rightTrue) % mod + (leftFalse * rightFalse) % mod) % mod;
                    break;
            }
        }

        return dp[i][j][isTrue] = ways;
    }
}