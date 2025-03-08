package _21_Graphs.Leetcode;

import java.util.ArrayDeque;

class _23_OrangesRotting_994 {
    public int orangesRotting(int[][] grid) {
//        0 representing an empty cell, 1 representing a fresh orange, or 2 representing a rotten orange.
        int m = grid.length, n = grid[0].length;

        ArrayDeque<int[]> q = new ArrayDeque<>(); //{row, col}
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // put all those multiple sources to que and mark them visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) { // rotten orange are source
                    q.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (grid[i][j] == 0) {// empty cells
                    visited[i][j] = true;
                }
            }
        }

        int minutes = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            while (size-- > 0) {
                int[] remove = q.removeFirst();
                int uRow = remove[0];
                int uCol = remove[1];

                for (int[] dir : dirs) {
                    int vRow = uRow + dir[0];
                    int vCol = uCol + dir[1];
                    if (vRow < 0 || vRow >= m || vCol < 0 || vCol >= n || visited[vRow][vCol]) continue;
                    visited[vRow][vCol] = true;
                    grid[vRow][vCol] = 2;// make this orange rotten
                    q.addLast(new int[]{vRow, vCol});
                }
            }
        }

        // find if any fresh orange is still remaining === 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // found fresh orange
                    return -1;
                }
            }
        }

        return minutes == -1 ? 0 : minutes;
    }
}