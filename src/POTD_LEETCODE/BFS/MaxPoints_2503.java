package POTD_LEETCODE.BFS;

import jdk.jfr.Description;

class MaxPoints_2503 {

    private boolean[][] visited;
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @Description("Gets TLE as we are exploring whole grid for each query index")
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] ans = new int[queries.length];
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < ans.length; i++) {
            visited = new boolean[m][n];
            ans[i] = dfs(0, 0, queries[i], m, n, grid);
        }
        return ans;
    }

    private int dfs(int row, int col, int target, int m, int n, int[][] grid) {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] >= target) {
            return 0;
        }

        visited[row][col] = true;
        int count = 1;

        for (int[] dir : dirs) {
            int dR = dir[0], dC = dir[1];
            count += dfs(row + dR, col + dC, target, m, n, grid);
        }

        return count;
    }
}