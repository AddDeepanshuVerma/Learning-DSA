package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.*;

@Description("Applied Dijkstra algorithm for each node in graph : n^2 * m :: TLE")
class DistanceLimitedPathsExist_1697 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] distance = new int[n][n];
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // stores : u -> {v, w}
        for (int[] edge : edgeList) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w});
        }

        for (int i = 0; i < n; i++) {
            distance[i] = dijkstra(i, n, adj);
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1], max = queries[i][2];
            ans[i] = distance[u][v] < max;
        }
        return ans;
    }

    // minimum of maxDistance while traveling from src to remaining nodes
    private int[] dijkstra(int src, int nv, HashMap<Integer, List<int[]>> adj) {
        int[] weight = new int[nv];
        Arrays.fill(weight, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);// stores : {node, curWeight}
        pq.offer(new int[]{src, 0});
        weight[src] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], uw = poll[1];
            if (uw > weight[u]) continue; // no need to explore with higher weight

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], vw = ngbr[1];
                if (Math.max(uw, vw) < weight[v]) {
                    weight[v] = Math.max(uw, vw);
                    pq.offer(new int[]{v, weight[v]});
                }
            }
        }

        return weight;
    }
}