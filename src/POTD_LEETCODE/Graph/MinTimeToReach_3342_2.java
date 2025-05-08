package POTD_LEETCODE.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

// As we thought of doing the same using Wave type BFS, hence remove PriorityQueue & used simple queue
// But GOT TLE 715 / 717 testcases passed
class MinTimeToReach_3342_2 {
    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length; // expecting that grid is nonEmpty

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] time = new int[n][m];
        for (int[] arr : time) Arrays.fill(arr, Integer.MAX_VALUE);

        ArrayDeque<int[]> pq = new ArrayDeque<>(); // contains : { row, col, arrivalTime}

        pq.offer(new int[]{0, 0, 0});
        time[0][0] = 0;

        // 1 : 0001
        // 2 : 0010 ^ 0011 = 0001 === 0001 ^ 0011 = 0010

        int delta = 1, mask = 3;

        while (!pq.isEmpty()) {
            int size = pq.size();

            while (size-- > 0) {
                int[] poll = pq.poll();
                int r = poll[0], c = poll[1], t = poll[2];
//                if (r == n - 1 && c == m - 1) return t; // reached the destination

                for (int[] dir : dirs) {
                    int r_ = r + dir[0], c_ = c + dir[1];
                    if (r_ < 0 || r_ >= n || c_ < 0 || c_ >= m) continue;

                    int t_ = Math.max(t, moveTime[r_][c_]) + delta;
                    if (t_ < time[r_][c_]) {
                        time[r_][c_] = t_;
                        pq.offer(new int[]{r_, c_, t_});
                    }
                }
            }
            delta ^= mask;
        }

        return time[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 89}, {86, 61, 11}};
        int ans = minTimeToReach(arr);
        System.out.println(ans);
    }

}