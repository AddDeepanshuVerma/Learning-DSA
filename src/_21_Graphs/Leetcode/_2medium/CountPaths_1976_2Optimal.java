package _21_Graphs.Leetcode._2medium;

import jdk.jfr.Description;

import java.util.*;

class CountPaths_1976_2Optimal {
    @Description("TLE removed as using the prior knowledge instead computing again but does not work with longRange")
    public int countPaths(int n, int[][] roads) {
        final int MOD = (int) (1e9 + 7);
        int src = 0, dst = n - 1;
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w});
        }

        int[] weight = new int[n];
        int[] count = new int[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {node, weight to reach this node}
//        ArrayDeque<int[]> q = new ArrayDeque<>(); // {node, weight to reach this node}

        q.offer(new int[]{src, 0});
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[src] = 0;
        count[src] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], uT = poll[1];

            for (int[] ngrb : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngrb[0], vT = ngrb[1];
                if (uT + vT < weight[v]) {
                    count[v] = count[u];
                    weight[v] = uT + vT;
                    q.offer(new int[]{v, weight[v]});
                } else if (uT + vT == weight[v]) {
                    count[v] += count[u] % MOD;
                }
            }
        }
        return count[dst];
    }
}