package _21_Graphs.Algo_MikePlayList;

import java.util.List;
import java.util.PriorityQueue;

public class _17Minimum_Spanning_Tree {
    /*
     * Spanning Tree : A subGraph of a given Graph: G(V,E) with V: vertices & E Edges is called spanning tree
     *                 When it is connected & has all the Vertices and V-1 number of edges
     *                 Hence it will be something like a linkedList with some nonCyclic branches.
     * A Graph can have multiple Spanning Tree but the one with minimum total weight is called : Minimum Spanning Tree (MST)
     * Also called as "MINIMUM WEIGHTED & CONNECTED SPANNING TREE === MST === Minimum SPANNING TREE"
     *
     * How: The ALGORITHM which is used to get the total weight of the minimum spanning tree out of a Graph is called
     * PRIM's Algorithm.
     * */
    static int spanningTreeSum(int V, int E, List<List<int[]>> adj) {
        // adj contains adj.get(0) pair of neighbour 0 is connected to u  = 0, {v, w}
        int nv = adj.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //{weight, currNode}
        boolean[] added_InMST = new boolean[nv];

        // base case
        pq.offer(new int[]{0, 0});
        //added_InMST[0] = true; incorrect : The only case where it will be added would be when it popped out of PQ.
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int w = poll[0];
            int u = poll[1];

            /*checking it again coz some higher weights might have added way earlier
            and meanwhile if same vertex got processed with minimum weight then this one with high weight is of noUSe.*/
            if (added_InMST[u]) continue;
            added_InMST[u] = true; // it will only be marked as added in MST when it's popped out of PQ.
            sum += w;

            for (int[] ngbr : adj.get(u)) {
                int v = ngbr[0];
                int vW = ngbr[1];
                if (!added_InMST[v]) {
                    pq.offer(new int[]{vW, v});
                }
            }
        }
        return sum;
    }
}
