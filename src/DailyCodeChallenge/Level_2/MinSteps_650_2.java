package DailyCodeChallenge.Level_2;

import jdk.jfr.Description;

import java.util.Arrays;

class MinSteps_650_2 {
    public static void main(String[] args) {
        MinSteps_650_2 obj = new MinSteps_650_2();
        System.out.println("minSteps = " + obj.minSteps(10));
        Arrays.stream(obj.dp).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    int[][] dp;

    public int minSteps(int n) {
        dp = new int[11][11];
        return solve(n, 1, 0);
    }

    @Description("Not working with memoization")
    private int solve(int val, int op, int ip) {
        if (op > val) return 10000;
        if (dp[op][ip] != 0) {
            System.out.println("dp[op][ip] = " + dp[op][ip]);
            return dp[val][op];
        }
        

        if (op == val) return 0;

        int paste = 10000, copy = 10000;

        if (ip != 0) paste = 1 + solve(val, op + ip, ip);
        if (op != ip) copy = 1 + solve(val, op, op);

        return dp[op][ip] = Math.min(copy, paste);
    }

}