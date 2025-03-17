package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MinScore_2492_1Dijkstra {
    public int minScore(int n, int[][] roads) {
        int src = 1, dst = n;
        // make the adj Lists
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // {u -> {(v, d),()...}}
        for (int[] road : roads) {
            int u = road[0], v = road[1], d = road[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, d});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, d});
        }

        // make normal queue [stores : {node, minimum distance occurred in this path}] & 'a minimum distance so far' array with size n+1
        // ArrayDeque<int[]> q = new ArrayDeque<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] minimum = new int[n + 1];
        Arrays.fill(minimum, Integer.MAX_VALUE);
        // preRequisite
        q.offer(new int[]{src, Integer.MAX_VALUE});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], uMin = poll[1];
            if (uMin > minimum[u]) continue; // no need to explore this path

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], delta = ngbr[1];
                int min = Math.min(uMin, delta);
                if (min < minimum[v]) {
                    minimum[v] = min;
                    q.offer(new int[]{v, min});
                }
            }
        }

        return minimum[dst] == Integer.MAX_VALUE ? -1 : minimum[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        var obj = new MinScore_2492_1Dijkstra();
        System.out.println(obj.minScore(n, roads));
    }
}