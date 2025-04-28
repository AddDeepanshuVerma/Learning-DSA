package _13_Maths.Medium;

import jdk.jfr.Description;

import java.util.Arrays;

class IntegerBreak_343_2 {
    public static void main(String[] args) {
        IntegerBreak_343_2 obj = new IntegerBreak_343_2();
        System.out.println(obj.integerBreak(10));
        System.out.println(Arrays.toString(dp));

    }
    private final static int[] dp = new int[60];

    static {
        new IntegerBreak_343_2().solve(58);
    }

    public int integerBreak(int n) {
        return solve(n);
    }

    @Description("Recursion + Memoization")
    private int solve(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            int curr = i * Math.max(n - i, solve(n - i));
            max = Math.max(max, curr);
        }
        return dp[n] = max;
    }
}