package _21_Graphs.Leetcode._5revision;

class FindMaxFish_2658 {
    public int findMaxFish(int[][] grid) {
        int max = 0;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                max = Math.max(max, dfs(i, j, grid, dirs, visited, m, n));
            }
        }
        return max;
    }

    private int dfs(int r, int c, int[][] grid, int[][] dirs, boolean[][] visited, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        int sum = grid[r][c];
        visited[r][c] = true;

        for (int[] dir : dirs) {
            int r_ = r + dir[0], c_ = c + dir[1];
            sum += dfs(r_, c_, grid, dirs, visited, m, n);
        }
        return sum;
    }
}