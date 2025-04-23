package _21_Graphs.Leetcode._5revision;

import java.util.ArrayDeque;

// Using simple queue
class MinimumObstacles_2290_2 {
    public int minimumObstacles(int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},};
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        // stores : { curr node row, curr node column & how many obstacle it took to come here}
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offerLast(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();
            int r = poll[0], c = poll[1], obs = poll[2];
            if (r == m - 1 && c == n - 1) { // reaches destination
                return obs;
            }

            for (int[] dir : dirs) {
                int r_ = r + dir[0];
                int c_ = c + dir[1];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n || visited[r_][c_]) continue;
                visited[r_][c_] = true;
                if (grid[r_][c_] == 1) {
                    q.offerLast(new int[]{r_, c_, obs + 1});
                } else {
                    q.offerFirst(new int[]{r_, c_, obs});
                }
            }
        }

        return -1;
    }
}