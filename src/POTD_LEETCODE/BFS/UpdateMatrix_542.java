package POTD_LEETCODE.BFS;

import java.util.ArrayDeque;

class UpdateMatrix_542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] seen = new boolean[m][n];
        ArrayDeque<int[]> dQue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dQue.offer(new int[]{0, i, j});
                    seen[i][j] = true;
                }
            }
        }

        while (!dQue.isEmpty()) {
            int size = dQue.size();
            while (size-- > 0) {
                int[] poll = dQue.poll();
                int val = poll[0], row = poll[1], col = poll[2];
                for (int[] dir : dirs) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || seen[nRow][nCol]) {
                        continue;
                    }
                    dQue.offer(new int[]{val + 1, nRow, nCol});
                    mat[nRow][nCol] = val + 1;
                    seen[nRow][nCol] = true;
                }
            }
        }
        return mat;
    }

    public int[][] updateMatrix_opt(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        ArrayDeque<int[]> dQue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dQue.offer(new int[]{0, i, j});
                } else {
                    mat[i][j] *= -1;
                }
            }
        }

        while (!dQue.isEmpty()) {
            int size = dQue.size();
            while (size-- > 0) {
                int[] poll = dQue.poll();
                int val = poll[0], row = poll[1], col = poll[2];
                for (int[] dir : dirs) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || mat[nRow][nCol] > 0) {
                        continue;
                    }
                    dQue.offer(new int[]{val + 1, nRow, nCol});
                    mat[nRow][nCol] = val + 1;
                }
            }
        }
        return mat;
    }
}