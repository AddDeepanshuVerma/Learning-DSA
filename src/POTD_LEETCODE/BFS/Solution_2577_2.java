package POTD_LEETCODE.BFS;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution_2577_2 {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        Queue<Pair> q = new PriorityQueue<>((a, b) -> a.time - b.time);
        char[][] visited = new char[m][n];
        q.offer(new Pair(0, 0, 0));
        visited[0][0] = 'v';

        while (!q.isEmpty()) {
            Pair pair = q.remove();
            int row = pair.row, col = pair.col, time = pair.time;

            if (row == m - 1 && col == n - 1) {
                return time;
            }

            for (int[] dir : dirs) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n) continue;
                if (visited[nRow][nCol] == 'v') continue;

                visited[nRow][nCol] = 'v';
                if (time + 1 >= grid[nRow][nCol]) {
                    q.offer(new Pair(nRow, nCol, time + 1));
                } else if ((grid[nRow][nCol] - time) % 2 == 0) {
                    q.offer(new Pair(nRow, nCol, grid[nRow][nCol] + 1));
                } else {
                    q.offer(new Pair(nRow, nCol, grid[nRow][nCol]));
                }
            }
        }
        return -1;
    }

    record Pair(int row, int col, int time) {
    }
}