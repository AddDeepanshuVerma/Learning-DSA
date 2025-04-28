package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.*;

class _13Dijkstra_Algo_Classic {

    private int dijkstra(int nv, int[][] edges) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
        int src = 0;
        int dst = nv - 1;

        int[] weight = new int[nv];
        Arrays.fill(weight, Integer.MAX_VALUE);

        // stores: {node, total weight used by specific path to reach this node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        weight[src] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0];
            int uW = poll[1];
            if (u == dst) break;          // the first time we touch the destination would have to be with minimal resources hence break
            if (weight[u] < uW) continue; // saves more than expected time

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0];
                int vW = ngbr[1];
                if (uW + vW < weight[v]) { // this paths weight + next node weight is less than next node's so far weight then update it
                    weight[v] = uW + vW;
                    pq.offer(new int[]{v, weight[v]});
                }
            }
        }

        return weight[dst] == Integer.MAX_VALUE ? -1 : weight[dst];
    }
}