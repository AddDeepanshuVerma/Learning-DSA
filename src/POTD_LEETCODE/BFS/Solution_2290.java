package POTD_LEETCODE.BFS;

import jdk.jfr.Description;

class Solution_2290 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(minimumObstacles(grid));
    }

    static int ans;

    @Description("Applied DFS using recursion : A BIG TLE")
    public static int minimumObstacles(int[][] grid) {
        char[][] visited = new char[grid.length][grid[0].length];
        ans = Integer.MAX_VALUE;

        int i = 0, j = 0, removal = 0;
        solve(grid, i, j, removal, visited);

        return ans;
    }

    private static void solve(int[][] grid, int i, int j, int removal, char[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || visited[i][j] == 'v') {
            return;
        }

        removal += grid[i][j];

        if (i == (grid.length - 1) && j == (grid[0].length - 1)) {
            ans = Math.min(ans, removal);
            return;
        }

        visited[i][j] = 'v';
        solve(grid, i + 1, j, removal, visited);
        solve(grid, i, j + 1, removal, visited);
        solve(grid, i - 1, j, removal, visited);
        solve(grid, i, j - 1, removal, visited);
        visited[i][j] = 0;

    }
}