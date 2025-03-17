package _21_Graphs.Leetcode._2medium;

import jdk.jfr.Description;

import java.util.*;

@Description("Works perfectly fine but BFS approach is way better in learning and understanding")
class FindCheapestPrice_787_Dijkstra {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] f : flights) {
            adj.computeIfAbsent(f[0], list -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); //{node, w, stops}
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);

        pq.offer(new int[]{src, 0, -1});
        weight[src] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], uw = poll[1], uStops = poll[2];

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0];
                int delta = ngbr[1];
                if (uw + delta < weight[v] && uStops + 1 <= k) {
                    weight[v] = uw + delta;
                    pq.offer(new int[]{v, uw + delta, uStops + 1});
                }
            }
        }
        return weight[dst] == Integer.MAX_VALUE ? -1 : weight[dst];
    }

    public static void main(String[] args) {
        var obj = new FindCheapestPrice_787_Dijkstra();
        int n = 5, src = 0, dst = 2, stops = 2;
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, stops));
    }
}