package _13_Maths.Medium;

import java.util.Arrays;

class NumSquares_279 {
    public static void main(String[] args) {
        NumSquares_279 obj = new NumSquares_279();
        System.out.println(obj.numSquares_Memo(999));
    }

    int[] dp = new int[10001];

    {
        Arrays.fill(dp, -1);
    }

    public int numSquares_Memo(int n) {
        if (n <= 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + numSquares_Memo(n - square));
        }
        return dp[n] = ans;
    }

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + numSquares(n - square));
        }
        return ans;
    }
}