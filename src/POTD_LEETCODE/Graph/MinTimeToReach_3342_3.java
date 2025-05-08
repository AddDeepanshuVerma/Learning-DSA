package POTD_LEETCODE.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

// As we can not use wave type BFS in PriorityQueue hence attached delta with each node being put in PQ itself
// All testcases passed
class MinTimeToReach_3342_3 {
    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length; // expecting that grid is nonEmpty

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] time = new int[n][m];
        for (int[] arr : time) Arrays.fill(arr, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); //{row, col, arrivalTime, delta that was used to reach here}

        pq.offer(new int[]{0, 0, 0, 2});
        time[0][0] = 0;

        // 1 : 0001
        // 2 : 0010 ^ 0011 = 0001 === 0001 ^ 0011 = 0010
        int mask = 3;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int r = poll[0], c = poll[1], arrival = poll[2], delta = poll[3];
            delta ^= mask;                                  // last time used delta needs to be updated now
            if (r == n - 1 && c == m - 1) return arrival;   // reached the destination

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1];
                if (r_ < 0 || r_ >= n || c_ < 0 || c_ >= m) continue;

                int t_ = Math.max(arrival, moveTime[r_][c_]) + delta;
                if (t_ < time[r_][c_]) {
                    time[r_][c_] = t_;
                    pq.offer(new int[]{r_, c_, t_, delta});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 89}, {86, 61, 11}};
        int ans = minTimeToReach(arr);
        System.out.println(ans);
    }
}