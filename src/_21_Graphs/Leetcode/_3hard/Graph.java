package _21_Graphs.Leetcode._3hard;

import java.util.*;

//Dijkstra Algorithm : 100 * (V + E)
class Graph {
    int nv;
    private final HashMap<Integer, List<int[]>> adj;

    public Graph(int n, int[][] edges) {
        nv = n;
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
    }

    public void addEdge(int[] edge) {
        adj.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        return dijkstra(node1, node2, nv, adj);
    }

    private int dijkstra(int src, int dst, int nv, HashMap<Integer, List<int[]>> adj) {
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
            if (u == dst) break;
            if (weight[u] < uW) continue;

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0];
                int vW = ngbr[1];
                if (uW + vW < weight[v]) {
                    weight[v] = uW + vW;
                    pq.offer(new int[]{v, weight[v]});
                }
            }
        }

        return weight[dst] == Integer.MAX_VALUE ? -1 : weight[dst];
    }
}