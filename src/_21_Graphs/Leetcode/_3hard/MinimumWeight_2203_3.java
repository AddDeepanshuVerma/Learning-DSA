package _21_Graphs.Leetcode._3hard;

import java.util.*;

class MinimumWeight_2203_3 {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        HashMap<Integer, List<long[]>> adj = new HashMap<>();
        HashMap<Integer, List<long[]>> reAdj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new long[]{v, w});
            reAdj.computeIfAbsent(v, list -> new ArrayList<>()).add(new long[]{u, w});
        }

        long[] first = dijkstra(src1, adj, n);
        long[] second = dijkstra(src2, adj, n);
        long[] destination = dijkstra(dest, reAdj, n);
        // we are saying every node can be a potential LCA for s1 & s2
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long w1 = first[i], w2 = second[i], w3 = destination[i];
            if (w1 == Long.MAX_VALUE || w2 == Long.MAX_VALUE || w3 == Long.MAX_VALUE) continue;

            ans = Math.min(ans, w1 + w2 + w3);
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    private long[] dijkstra(int src, HashMap<Integer, List<long[]>> adj, int nv) {
        long[] weight = new long[nv];
        Arrays.fill(weight, Long.MAX_VALUE);

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.offer(new long[]{src, 0});
        weight[src] = 0;

        while (!q.isEmpty()) {
            long[] poll = q.poll();
            int u = (int) poll[0];
            long uw = poll[1];

            if (uw > weight[u]) continue;

            for (long[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                long v = ngbr[0], vw = ngbr[1];

                if (uw + vw < weight[(int) v]) {
                    weight[(int) v] = uw + vw;
                    q.offer(new long[]{v, weight[(int) v]});
                }
            }
        }
        return weight;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 2, 2}, {0, 5, 6}, {1, 0, 3}, {1, 4, 5}, {2, 1, 1}, {2, 3, 3}, {2, 3, 4}, {3, 4, 2}, {4, 5, 1}};
        long ans = new MinimumWeight_2203_3().minimumWeight(n, edges, 0, 1, 5);
        System.out.println(ans);
    }
}