package _21_Graphs.Leetcode._5revision;

import java.util.ArrayDeque;

// Should have been done via dijkstra BUT as edge cost is 0/1 hence applied 0-1-BFS
class MinCost_1368 {
    public int minCost(int[][] grid) {
        // 1, 2, 3, 4 ::: right, left, lower, upper
        int[][] dirs = {{0, 1, 1}, {0, -1, 2}, {1, 0, 3}, {-1, 0, 4}}; // stores {row, col, direction}
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        ArrayDeque<int[]> q = new ArrayDeque<>(); // {row, col, cost}

        q.offerLast(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();
            int r = poll[0], c = poll[1], cost = poll[2];
            if (visited[r][c]) continue;
            visited[r][c] = true;
            if (r == m - 1 && c == n - 1) return cost; // reached destination with the lowest cost

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1], direction = dir[2];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n) continue;
                if (grid[r][c] == direction) {
                    q.addFirst(new int[]{r_, c_, cost});
                } else {
                    q.addLast(new int[]{r_, c_, cost + 1});
                }
            }
        }

        return -1;
    }
}