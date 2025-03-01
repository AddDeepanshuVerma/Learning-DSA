package _21_Graphs.Leetcode;

import java.util.*;

class _10NetworkDelayTime_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // given node are from 1 to n
        int[] weight = new int[n + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // {u, List<>{v, w}}
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
        }

        int src = k;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //{node, weight}
        pq.offer(new int[]{src, 0});
        weight[src] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0];
            int w = poll[1];

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0];
                int delta = ngbr[1];

                if (w + delta < weight[v]) {
                    weight[v] = w + delta;
                    pq.offer(new int[]{v, w + delta});
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < weight.length; i++) {
            if (weight[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, weight[i]);
        }
        return ans;
    }
}