package POTD_LEETCODE.Graph;

import java.util.PriorityQueue;

// HERE WE AS PER QUESTION, WHEN WE MOVE FROM (0,0) YOU ARE ALWAYS LEAVING AT TIME === 0(MISSED IT), APPLYING IT NOW
// BFS + PriorityQueue + visited HashSet + marking visited only after popping
class MinTimeToReach_3341 {
    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // stores : {row, col, reached}

        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int r = poll[0], c = poll[1], arrivalTime = poll[2];

            if (visited[r][c]) continue;
            visited[r][c] = true;
            if (r == n - 1 && c == m - 1) return arrivalTime; // reached Destination

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1];
                if (r_ < 0 || r_ >= n || c_ < 0 || c_ >= m || visited[r_][c_]) continue;
                int vArrivalTime = Math.max(arrivalTime, moveTime[r_][c_]) + 1;
                pq.offer(new int[]{r_, c_, vArrivalTime});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 4}, {4, 4}};
        int min = minTimeToReach(arr);
        System.out.println("min = " + min);
    }
}