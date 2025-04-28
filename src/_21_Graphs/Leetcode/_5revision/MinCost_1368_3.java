package _21_Graphs.Leetcode._5revision;

import java.util.Arrays;
import java.util.PriorityQueue;

// Applying pure dijkstra instead of any other technique
class MinCost_1368_3 {
    public int minCost(int[][] grid) {
        // 1, 2, 3, 4 ::: right, left, lower, upper
        int[][] dirs = {{0, 1, 1}, {0, -1, 2}, {1, 0, 3}, {-1, 0, 4}}; // stores {row, col, direction}
        int m = grid.length, n = grid[0].length;

        int[][] minWeight = new int[m][n];
        for (int[] arr : minWeight) Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]); // {row, col, cost}

        q.offer(new int[]{0, 0, 0});
        minWeight[0][0] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0], c = poll[1], cost = poll[2];
            if (r == m - 1 && c == n - 1) return cost; // reached destination with the lowest cost as using PQ

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1], direction = dir[2];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n) continue;
                int newCost = grid[r][c] == direction ? cost : cost + 1;

                if (newCost < minWeight[r_][c_]) {
                    minWeight[r_][c_] = newCost;
                    q.offer(new int[]{r_, c_, newCost});
                }
            }
        }

        return minWeight[m - 1][n - 1];
    }
}