package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MaxProbability_1514_2 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Approach : Need to apply dijkstra algorithm but as much as max weight possible bw two vertexes
        HashMap<Integer, List<Pair<Integer, Double>>> adj = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double w = succProb[i];

            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new Pair<>(v, w));
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new Pair<>(u, w));
        }

        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight)); // stores: node, curr weight
        boolean[] visited = new boolean[n];

        // bfs prerequisite
        pq.offer(new Pair<>(start_node, 1.0));
        // now find as max value as we can get
        while (!pq.isEmpty()) {
            Pair<Integer, Double> poll = pq.poll();
            int u = poll.node;
            double uw = poll.weight;

            if (visited[u]) continue;
            visited[u] = true;

            // first time match would give us max probability as it will keep on decreasing
            // as per time passes & this is the reason we are using maxHeap priority queue
            if (u == end_node) return uw;

            for (var ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr.node;
                double vw = ngbr.weight;
                if (visited[v]) continue;
                pq.offer(new Pair<>(v, uw * vw));
            }
        }

        return 0.0;
    }

    record Pair<K, V>(K node, V weight) {

    }

    public static void main(String[] args) {
        var obj = new MaxProbability_1514_2();
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        double ans = obj.maxProbability(n, edges, succProb, 0, 2);
        System.out.println(ans);
    }
}