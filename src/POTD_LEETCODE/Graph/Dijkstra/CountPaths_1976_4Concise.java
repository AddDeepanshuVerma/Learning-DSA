package POTD_LEETCODE.Graph.Dijkstra;

import java.util.*;

class CountPaths_1976_4Concise {
    public int countPaths(int n, int[][] roads) {
        HashMap<Long, List<long[]>> adj = new HashMap<>();
        for (int[] road : roads) {
            long u = road[0], v = road[1], w = road[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new long[]{v, w});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new long[]{u, w});
        }
        return dijkstra(adj, n);
    }

    private static int dijkstra(HashMap<Long, List<long[]>> adj, int n) {
        int MOD = (int) (1e9 + 7), src = 0;
        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[src] = 0;
        int[] ways = new int[n];
        ways[src] = 1;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[1])); // {node, weight to reach this node}
        minHeap.offer(new long[]{src, 0});
        while (!minHeap.isEmpty()) {
            long[] poll = minHeap.poll();
            long u = poll[0], uT = poll[1];
            if (uT > time[(int) u]) continue;// saves significant time
            for (long[] ngrb : adj.getOrDefault(u, Collections.emptyList())) {
                int v = (int) ngrb[0];
                long vT = ngrb[1];
                if (time[v] > uT + vT) {
                    time[v] = uT + vT;
                    ways[v] = ways[(int) u];
                    minHeap.offer(new long[]{v, time[v]});
                } else if (time[v] == uT + vT) {
                    ways[v] = (ways[v] + ways[(int) u] % MOD) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}