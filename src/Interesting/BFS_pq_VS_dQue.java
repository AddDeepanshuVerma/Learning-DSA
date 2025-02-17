package Interesting;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

class BFS_pq_VS_dQue {

    public int[][] highestPeak(int[][] isWater) {
        /*
         * Make a priority queue {value, row, column}, it'll be min-heap wrt value.
         * Also make a visited 2d Grid.
         * 1. Find all water cells indexes and put those indexes in priority-queue also mark them zero in the grid & marked as visited
         * 2. now bfs on queue, traverse all value from queue and add it's neighbour to pQue again if not visited
         * 3. max value ever assigned is our answer
         * */
        int m = isWater.length, n = isWater[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] seen = new boolean[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, up, down

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    pq.offer(new int[]{0, i, j});
                    isWater[i][j] = 0;
                    seen[i][j] = true;
                }
            }
        }
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int value = poll[0], row = poll[1], col = poll[2];

            for (int[] dir : dirs) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || seen[nRow][nCol]) {
                    continue;
                }
                pq.offer(new int[]{value + 1, nRow, nCol});
                isWater[nRow][nCol] = value + 1;
                seen[nRow][nCol] = true;
            }
        }
        return isWater;
    }

    public int[][] highestPeak_opt(int[][] isWater) {
        /*
         * There can be no need of priority queue as we by ourselves are offering the elements in the queue in ascending order itself
         * Hence we can simply use a queue(Dequeue) in which we pop from first and add to last only
         * */
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
                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || seen[nRow][nCol]) {
                    continue;
                }
                dQue.addLast(new int[]{value + 1, nRow, nCol});
                isWater[nRow][nCol] = value + 1;
                seen[nRow][nCol] = true;
            }
        }
        return isWater;
    }
}