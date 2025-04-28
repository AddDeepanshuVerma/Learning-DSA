package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.ArrayDeque;

class _23_HighestPeak_1765 {
    // Multi Source BFS
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        ArrayDeque<int[]> dQue = new ArrayDeque<>();
        boolean[][] seen = new boolean[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, up, down

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    dQue.addLast(new int[]{0, i, j});
                    isWater[i][j] = 0;
                    seen[i][j] = true;
                }
            }
        }
        while (!dQue.isEmpty()) {
            int[] poll = dQue.removeFirst();
            int value = poll[0], row = poll[1], col = poll[2];

            for (int[] dir : dirs) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || seen[nRow][nCol]) continue;
                dQue.addLast(new int[]{value + 1, nRow, nCol});
                isWater[nRow][nCol] = value + 1; // next adjacent cell will have a value, +1 to previous one
                seen[nRow][nCol] = true;
            }
        }
        return isWater;
    }
}