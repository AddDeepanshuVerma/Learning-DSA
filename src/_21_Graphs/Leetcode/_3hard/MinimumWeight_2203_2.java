package _21_Graphs.Leetcode._3hard;

import java.util.*;

// Works perfectly fine, just it does not handle out of INTMAX range weights, FUCKING SINGLE TEST CASE NEEDS TO BE HANDLED
class MinimumWeight_2203_2 {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        HashMap<Integer, List<int[]>> reAdj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
            reAdj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w});
        }

        int[] first = dijkstra(src1, adj, n);
        int[] second = dijkstra(src2, adj, n);
        int[] destination = dijkstra(dest, reAdj, n);

        // we are saying every node can be a potential LCA for s1 & s2
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int w1 = first[i], w2 = second[i], w3 = destination[i];
            if (w1 == Integer.MAX_VALUE || w2 == Integer.MAX_VALUE || w3 == Integer.MAX_VALUE) continue;

            ans = Math.min(ans, w1 + w2 + w3);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
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