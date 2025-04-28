package _13_Maths.Medium;

import java.util.Arrays;

class UniquePaths_62_2 {
    public static void main(String[] args) {
        UniquePaths_62_2 obj = new UniquePaths_62_2();
        System.out.println(obj.uniquePaths(100, 100));
    }

    int[][] dp = new int[101][101];

    public int uniquePaths(int m, int n) {
        Arrays.stream(dp)
              .forEach(arr -> Arrays.fill(arr, -1));
        return solve(0, 0, m, n, 0);
    }

    private int solve(int row, int col, int m, int n, int count) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        if (row >= m || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return ++count;
        }
        return dp[row][col] = solve(row + 1, col, m, n, count) + solve(row, col + 1, m, n, count);
    }
}