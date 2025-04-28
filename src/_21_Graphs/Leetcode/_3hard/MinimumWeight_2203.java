package _21_Graphs.Leetcode._3hard;

import java.util.*;

// does not work as we did not think about the LCA for src1 & scr2 when going towards dest
class MinimumWeight_2203 {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
        }

        int[] first = dijkstra(src1, adj, n);
        int[] second = dijkstra(src2, adj, n);

        if (first[dest] == Integer.MAX_VALUE || second[dest] == Integer.MAX_VALUE) {
            return -1;
        }

        int w1 = Integer.MAX_VALUE, w2 = Integer.MAX_VALUE, w3 = Integer.MAX_VALUE;

        w1 = first[dest] + second[dest];
        if (first[src2] != Integer.MAX_VALUE) {
            w2 = first[src2] + second[dest];
        }
        if (second[src1] != Integer.MAX_VALUE) {
            w3 = second[src1] + first[dest];
        }

        return Math.min(w1, Math.min(w2, w3));
    }

    private int[] dijkstra(int src, HashMap<Integer, List<int[]>> adj, int nv) {
        int[] weight = new int[nv];
        Arrays.fill(weight, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{src, 0});
        weight[src] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0];
            int uw = poll[1];

            if (uw > weight[u]) continue;

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], vw = ngbr[1];

                if (uw + vw < weight[v]) {
                    weight[v] = uw + vw;
                    q.offer(new int[]{v, weight[v]});
                }
            }
        }
        return weight;
    }
}