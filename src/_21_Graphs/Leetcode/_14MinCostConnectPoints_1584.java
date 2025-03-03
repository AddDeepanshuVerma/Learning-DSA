package _21_Graphs.Leetcode;

import java.util.PriorityQueue;

class _14MinCostConnectPoints_1584 {
    public int minCostConnectPoints(int[][] points) {
        /*
         * All paths are distinct, we need to return the minimum cost to make all points connected
         * It is nothing but calculate the sum of minimum spanning tree
         * */

        int nv = points.length;
        boolean[] inMst = new boolean[nv];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {weight, index of node}
        pq.offer(new int[]{0, 0});
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int w = poll[0];
            int index = poll[1];

            if (inMst[index]) continue;
            inMst[index] = true;
            sum += w;

            for (int i = 0; i < points.length; i++) {
                if (index == i) continue;
                if (!inMst[i]) { // does reduce the TC effectively
                    int effective_weight = Math.abs(points[index][0] - points[i][0]) + Math.abs(points[index][1] - points[i][1]);
                    pq.offer(new int[]{effective_weight, i});
                }
            }
        }
        return sum;
    }
}