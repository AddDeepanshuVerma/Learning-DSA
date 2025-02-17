package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

import jdk.jfr.Description;

public class _4Evaluate_expression_recursion {
    private static final int mod = 1000000007;

    @Description("Using recursion return type as int, based on what is asked like : count of true / false")
    public static void main(String[] args) {
        String s = "T|T&F^T";
        int ans = dfs(0, s.length() - 1, s, 1); // isTrue == 1 ~ true
        System.out.println(ans);
    }

    private static int dfs(int i, int j, String s, int isTrue) {
        if (i > j) return 0;

        if (i == j) {
            char ch = s.charAt(i);
            return (isTrue == 1) ? ((ch == 'T') ? 1 : 0) : ((ch == 'F') ? 1 : 0);
        }

        int ways = 0;
        for (int k = i + 1; k < j; k += 2) {
            int leftTrue = dfs(i, k - 1, s, 1);
            int leftFalse = dfs(i, k - 1, s, 0);
            int rightTrue = dfs(k + 1, j, s, 1);
            int rightFalse = dfs(k + 1, j, s, 0);
            switch (s.charAt(k)) {
                case '|' -> {
                    if (isTrue == 1) ways = (ways + (leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod + (leftTrue * rightTrue) % mod) % mod;
                    else ways = (ways + (leftFalse * rightFalse) % mod) % mod;
                }
                case '&' -> {
                    if (isTrue == 1) ways = (ways + (leftTrue * rightTrue) % mod) % mod;
                    else ways = (ways + (leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod + (leftFalse * rightFalse) % mod) % mod;
                }
                case '^' -> {
                    if (isTrue == 1) ways = (ways + (leftTrue * rightFalse) % mod + (leftFalse * rightTrue) % mod) % mod;
                    else ways = (ways + (leftTrue * rightTrue) % mod + (leftFalse * rightFalse) % mod) % mod;
                }
            }
        }
        return ways;
    }
}
