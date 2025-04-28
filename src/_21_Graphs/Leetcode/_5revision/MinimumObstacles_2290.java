package _21_Graphs.Leetcode._5revision;

import java.util.PriorityQueue;

// Works fine, using priorityQueue
class MinimumObstacles_2290 {
    public int minimumObstacles(int[][] grid) {
        /*
         * Given :
         * grid[0][0] == grid[m - 1][n - 1] == 0
         * grid[i][j] is either 0 or 1
         * */

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},};
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        // stores : { curr node row, curr node column & how many obstacle it took to come here}
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0], c = poll[1], obs = poll[2];
            if (r == m - 1 && c == n - 1) { // reaches destination
                return obs;
            }

            for (int[] dir : dirs) {
                int r_ = r + dir[0];
                int c_ = c + dir[1];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n || visited[r_][c_]) continue;
                visited[r_][c_] = true;
                q.offer(new int[]{r_, c_, obs + grid[r_][c_]});
            }
        }
        return -1;
    }
}