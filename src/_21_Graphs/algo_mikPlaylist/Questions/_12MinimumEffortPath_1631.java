package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.Arrays;
import java.util.PriorityQueue;

class _12MinimumEffortPath_1631 {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length, c = heights[0].length;

        int[][] maxJump = new int[r][c];
        for (int[] arr : maxJump) Arrays.fill(arr, Integer.MAX_VALUE);

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // {row, col, max hurdle so far}
        pq.offer(new int[]{0, 0, 0}); // Hiker is already present at {0,0} hence no jump was made in initially
        maxJump[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int ur = poll[0];
            int uc = poll[1];
            int jump = poll[2];

            for (int[] dir : dirs) {
                int vr = ur + dir[0];
                int vc = uc + dir[1];
                if (vr < 0 || vr >= r || vc < 0 || vc >= c) continue; // invalid cases
                int vJump = Math.max(Math.abs(heights[vr][vc] - heights[ur][uc]), jump);
                if (vJump < maxJump[vr][vc]) {
                    maxJump[vr][vc] = vJump;
                    pq.offer(new int[]{vr, vc, vJump});
                }
            }
        }
        return maxJump[r - 1][c - 1];
    }
}