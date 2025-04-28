package POTD_LEETCODE.BFS;

import jdk.jfr.Description;

import java.util.ArrayDeque;

@Description(" Does not work as we could not restrict to check the previous stepped path again and again. check Solution_2577_2 for solution")
class Solution_2577 {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.addLast(new Pair(0, 0));
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair remove = q.removeFirst();
                int row = remove.row, col = remove.col;
                if (row == m - 1 && col == n - 1) {
                    return time;
                }
                for (int[] d : dir) {
                    int nRow = row + d[0];
                    int nCol = col + d[1];
                    if (nRow < 0 || nCol < 0 || nRow >= m || nCol >= n) continue;
                    if (grid[nRow][nCol] <= (time + 1)) {
                        q.addLast(new Pair(nRow, nCol));
                    }
                }
            }
            time++;
        }
        return -1;
    }

    record Pair(int row, int col) {
    }
}