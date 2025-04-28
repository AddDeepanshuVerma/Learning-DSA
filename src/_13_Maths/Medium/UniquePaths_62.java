package _13_Maths.Medium;

import java.util.Arrays;

class UniquePaths_62 {
    public static void main(String[] args) {
        UniquePaths_62 obj = new UniquePaths_62();
        System.out.println(obj.uniquePaths(23, 12));
    }

    int count = 0;
    public int uniquePaths(int m, int n) {
        solve(0, 0, m, n);
        return count;
    }

    private void solve(int row, int col, int m, int n) {

        if (row >= m || col >= n) {
            return;
        }
        if (row == m - 1 && col == n - 1) {
            count++;
        }
        solve(row + 1, col, m, n);
        solve(row, col + 1, m, n);
    }
}