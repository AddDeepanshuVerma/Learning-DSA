package POTD_LEETCODE.Graph.Dijkstra;

import jdk.jfr.Description;

import java.util.*;

class CountPaths_1976_3longSupport {
    @Description("converted EVERYTHING possible to long type data.....")
    public int countPaths(int n, int[][] roads) {
        final long MOD = (long) (1e9 + 7);
        int src = 0, dst = n - 1;
        HashMap<Long, List<long[]>> adj = new HashMap<>();
        for (int[] road : roads) {
            long u = road[0], v = road[1], w = road[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new long[]{v, w});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new long[]{u, w});
        }

        long[] weight = new long[n];
        long[] count = new long[n];
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[1])); // {node, weight to reach this node}

        q.offer(new long[]{src, 0});
        Arrays.fill(weight, Long.MAX_VALUE);
        weight[src] = 0;
        count[src] = 1;

        while (!q.isEmpty()) {
            long[] poll = q.poll();
            long u = poll[0], uT = poll[1];

            for (long[] ngrb : adj.getOrDefault(u, Collections.emptyList())) {
                int v = (int) ngrb[0];
                long vT = ngrb[1];
                if (uT + vT < weight[v]) {
                    count[v] = count[(int) u];
                    weight[v] = uT + vT;
                    q.offer(new long[]{v, weight[v]});
                } else if (uT + vT == weight[v]) {
                    count[v] = (count[v] + count[(int) u] % MOD) % MOD;
                }
            }
        }
        return (int) count[dst];
    }
}