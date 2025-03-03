package _21_Graphs.Algo_MikePlayList;

import java.util.List;
import java.util.PriorityQueue;

public class _17Minimum_Spanning_Tree_cmpt {
    static int spanningTreeSum(int V, int E, List<List<int[]>> adj) {
        int nv = adj.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //{weight, currNode}
        boolean[] InMST = new boolean[nv];

        pq.offer(new int[]{0, 0});
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int w = poll[0];
            int u = poll[1];

            if (InMST[u]) continue; // if this node is already in our MST then a better edge must have added so ignore this one
            InMST[u] = true;
            sum += w;

            for (int[] ngbr : adj.get(u)) {
                if (!InMST[ngbr[0]]) { // [0] refers to node
                    pq.offer(new int[]{ngbr[1], ngbr[0]});
                }
            }
        }
        return sum;
    }
}
