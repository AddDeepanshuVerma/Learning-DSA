package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.PriorityQueue;

class _14MinCostConnectPoints_1584_Prims {
    public int minCostConnectPoints(int[][] points) {
        /*
         * All paths are distinct, we need to return the minimum cost to make all points connected
         * It is nothing but calculate the sum of minimum spanning tree
         * */
        int nv = points.length;
        boolean[] inMst = new boolean[nv];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {weight, index of node}
        pq.offer(new int[]{0, 0}); // meaning we entered into 0th index node with no weight & need to explore further.
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int w = poll[0];
            int vIdx = poll[1];

            if (inMst[vIdx]) continue;
            inMst[vIdx] = true;
            sum += w;

            for (int i = 0; i < points.length; i++) {
                if (vIdx == i) continue;
                if (!inMst[i]) { // does reduce the TC effectively
                    int effective_weight = Math.abs(points[vIdx][0] - points[i][0]) + Math.abs(points[vIdx][1] - points[i][1]);
                    pq.offer(new int[]{effective_weight, i});
                }
            }
        }
        return sum;
    }
}