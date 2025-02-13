package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

import jdk.jfr.Description;

public class _7Evaluate_expression_recursion_2 {
    private static final int mod = 1000000007;

    @Description("Using recursion return type as of Pair<>, hence each branch will return both imp data of counting true & false both")
    public static void main(String[] args) {
        String s = "T|T&F^T";
        Pair both = dfs(0, s.length() - 1, s);
        System.out.println(both.tru());
    }

    private static Pair dfs(int i, int j, String s) {
        if (i > j) return new Pair(0, 0);

        if (i == j) {
            char ch = s.charAt(i);
            return new Pair(ch == 'T' ? 1 : 0, ch == 'F' ? 1 : 0);
        }

        int truWays = 0, falWays = 0;
        for (int k = i + 1; k < j; k += 2) {
            Pair left = dfs(i, k - 1, s);
            Pair right = dfs(k + 1, j, s);
            switch (s.charAt(k)) {
                case '|' -> {
                    truWays = (truWays + (left.tru() * right.fal()) % mod + (left.fal() * right.tru()) % mod + (left.tru() * right.tru()) % mod) % mod;
                    falWays = (falWays + (left.fal() * right.fal) % mod) % mod;
                }
                case '&' -> {
                    truWays = (truWays + (left.tru() * right.tru()) % mod) % mod;
                    falWays = (falWays + (left.tru() * right.fal()) % mod + (left.fal() * right.tru()) % mod + (left.fal() * right.fal()) % mod) % mod;
                }
                case '^' -> {
                    truWays = (truWays + (left.tru() * right.fal()) % mod + (left.fal() * right.tru()) % mod) % mod;
                    falWays = (falWays + (left.tru() * right.tru()) % mod + (left.fal() * right.fal()) % mod) % mod;
                }
            }
        }
        return new Pair(truWays, falWays);
    }

    record Pair(Integer tru, Integer fal) {
    }
}
