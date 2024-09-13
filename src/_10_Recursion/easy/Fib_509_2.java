package _10_Recursion.easy;

class Fib_509_2 {
    private final static int[] dp = new int[31];

    static {
        fib(30);
    }

    public static int fib(int n) {
        if (n < 2) return n;
        if (dp[n] != 0) return dp[n];
        return dp[n] = fib(n - 1) + fib(n - 2);
    }
}
