package POTD_LEETCODE.BFS;

import java.util.ArrayDeque;

class FindMaxFish_2658 {
    public static void main(String[] args) {
        int[][] grid = {{0, 3, 8}};
        System.out.println(findMaxFish(grid));
    }

    public static int findMaxFish(int[][] grid) {
        /*
         * Go through each value in grid 1 by 1 and run a BFS finding all the connected water to it and count all the fishes along the way
         * While traversing keep marking the previous water as island
         * now get the maximum we can get if we go through all number of fishLand
         * Maximum one would be the answer
         * -- Problem is similar to number of islands --
         * */
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
//                     run BFS/DFS from this source
//                    ans = Math.max(ans, bfs(i, j, grid, dirs, m, n));
                    ans = Math.max(ans, dfs(i, j, grid, dirs, m, n));
                }
            }
        }
        return ans;
    }

    private static int dfs(int row, int col, int[][] grid, int[][] dirs, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) return 0;

        int fish = grid[row][col];
        grid[row][col] = 0;

        for (int[] dir : dirs) {
            fish += dfs(row + dir[0], col + dir[1], grid, dirs, m, n);
        }
        return fish;
    }

    private static int bfs(int i, int j, int[][] grid, int[][] dirs, int m, int n) {
        int count = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>(); // stores {row, column}

        q.offer(new int[]{i, j});
        count += grid[i][j];
        grid[i][j] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0], c = poll[1];

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n || grid[r_][c_] == 0) continue;
                count += grid[r_][c_];
                grid[r_][c_] = 0;
                q.offer(new int[]{r_, c_});
            }
        }
        return count;
    }
}