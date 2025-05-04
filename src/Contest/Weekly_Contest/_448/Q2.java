package Contest.Weekly_Contest._448;

import java.util.Arrays;

public class Q2 {

    public int[][] specialGrid(int N) {
        /*
         * Recursion will be there,
         * We will break the grid in 4 parts
         * Each part will return the max element used by it so far
         * that max element will work as min element for next compartment
         * */
        int m = 1 << N, n = m;
        int[][] grid = new int[m][n];

        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;
        int min = 0;
        dfs(left, right, top, bottom, grid, m, n, min);
        return grid;
    }

    private int dfs(int left, int right, int top, int bottom, int[][] grid, int m, int n, int min) {
        if (left == right) {
            grid[top][left] = min;
            return min;
        }

        int colMid = (left + right) >> 1;
        int rowMid = (top + bottom) >> 1;

        int min1 = dfs(colMid + 1, right, top, rowMid, grid, m, n, min);
        int min2 = dfs(colMid + 1, right, rowMid + 1, bottom, grid, m, n, min1 + 1);
        int min3 = dfs(left, colMid, rowMid + 1, bottom, grid, m, n, min2 + 1);
        int min4 = dfs(left, colMid, top, rowMid, grid, m, n, min3 + 1);

        return min4;
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        int[][] ans = obj.specialGrid(4);

        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
