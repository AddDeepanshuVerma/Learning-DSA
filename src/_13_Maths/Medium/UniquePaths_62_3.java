package _13_Maths.Medium;

import java.util.Arrays;

class UniquePaths_62_3 {
    public static void main(String[] args) {
        UniquePaths_62_3 obj = new UniquePaths_62_3();
        System.out.println(obj.uniquePaths(0, 0));
    }

    int[][] dp = new int[101][101];

    {
        Arrays.stream(dp)
              .forEach(arr -> Arrays.fill(arr, -1));
    }

    public int uniquePaths(int m, int n) {
        if (dp[m][n] != -1) return dp[m][n];
        if (m <= 0 || n <= 0) return 0; // for mxn matrix we are considering m, m-1... till 1, not zero
        if (m-1 == 0 && n-1 == 0) return 1;
        return dp[m][n] = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

}