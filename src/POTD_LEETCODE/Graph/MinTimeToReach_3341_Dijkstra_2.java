package POTD_LEETCODE.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//Dijkstra Algorithm
class MinTimeToReach_3341_Dijkstra_2 {
    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] time = new int[n][m];
        for (int[] arr : time) Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // stores : {row, col, arrivalTime}

        pq.offer(new int[]{0, 0, 0});
        time[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int r = poll[0], c = poll[1], t = poll[2];
            // arrived at destination
            if (r == n - 1 && c == m - 1) return t;

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1];
                if (r_ < 0 || r_ >= n || c_ < 0 || c_ >= m) continue;
                int t_ = Math.max(t, moveTime[r_][c_]) + 1;
                if (t_ < time[r_][c_]) {
                    time[r_][c_] = t_;
                    pq.offer(new int[]{r_, c_, t_});
                }
            }
        }

        return time[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 4}, {4, 4}};
        int min = minTimeToReach(arr);
        System.out.println("min = " + min);
    }
}