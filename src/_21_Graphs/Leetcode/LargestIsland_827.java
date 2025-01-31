package _21_Graphs.Leetcode;

class LargestIsland_827 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        var obj = new LargestIsland_827();
        System.out.println(obj.largestIsland(grid));
    }

    public int largestIsland(int[][] grid) {
        /*
         * Steps :
         * check if there is no water(0) but land(1) only then answer would be n<<1
         * Now go through each item in grid and when found water consider that land and do a BFS or DFS to get max land
         * Also it's a backTrack so after exploring that water as a land convert it back to water
         * */

        int m = grid.length, n = grid[0].length;
        // checking if grid is full of land only
        int waterCount = 0;
        for (int[] ints : grid)
            for (int val : ints)
                if (val == 0) waterCount++;
        if (waterCount == 0) return n << 1;

        int max = Integer.MIN_VALUE;
        boolean[][] visited;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    visited = new boolean[m][n];
                    max = Math.max(max, dfs(i, j, m, n, grid, visited, dirs));
                    grid[i][j] = 0;
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int m, int n, int[][] grid, boolean[][] visited, int[][] dirs) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int sum = grid[r][c];
        for (int[] dir : dirs) {
            int r_ = r + dir[0], c_ = c + dir[1];
            sum += dfs(r_, c_, m, n, grid, visited, dirs);
        }
        return sum;
    }
}