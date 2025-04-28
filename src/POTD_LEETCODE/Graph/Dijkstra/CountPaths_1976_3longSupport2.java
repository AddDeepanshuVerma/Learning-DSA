package POTD_LEETCODE.Graph.Dijkstra;

import jdk.jfr.Description;

import java.util.*;

class CountPaths_1976_3longSupport2 {
    @Description("converted EVERYTHING possible to long type data..... + using arrayList instead of HashMap")
    public int countPaths(int n, int[][] roads) {
        final long MOD = (long) (1e9 + 7);
        int src = 0, dst = n - 1;

        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new long[]{v, w});
            adj.get(v).add(new long[]{u, w});
        }

        long[] time = new long[n];
        long[] count = new long[n];
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[1])); // {node, weight to reach this node}

        q.offer(new long[]{src, 0});
        Arrays.fill(time, Long.MAX_VALUE);
        time[src] = 0;
        count[src] = 1;

        while (!q.isEmpty()) {
            long[] poll = q.poll();
            int u = (int) poll[0];
            long uT = poll[1];
            if (uT > time[u]) continue;

            for (long[] ngrb : adj.get(u)) {
                int v = (int) ngrb[0];
                long vT = ngrb[1];
                if (uT + vT < time[v]) {
                    count[v] = count[u];
                    time[v] = uT + vT;
                    q.offer(new long[]{v, time[v]});
                } else if (uT + vT == time[v]) {
                    count[v] = (count[v] + count[u] % MOD) % MOD;
                }
            }
        }
        return (int) count[dst];
    }
}