package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MinMaxWeight_3419_2 {
    public static int minMaxWeight(int n, int[][] edges, int threshold) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // {u -> {v, w}...}
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n];
        List<Integer> topo = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // stores {reached node, maxWeight so far, parent Node}
        pq.offer(new int[]{0, 0});
        int max = -1;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], w = poll[1];
            if (visited[u]) continue;

            visited[u] = true;
            topo.add(u);
            max = Math.max(max, w);

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], vw = ngbr[1];
                pq.offer(new int[]{v, vw});
            }

        }

        return topo.size() == n ? max : -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{2, 0, 75}, {1, 0, 69}, {1, 0, 97}};
        int threshold = 1;

        int ans = minMaxWeight(n, edges, threshold);
        System.out.println("ans = " + ans);
    }

}