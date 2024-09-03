package Interesting;

import java.util.*;

public class DijkstraUsecase {
    record Pair<K, V>(K key, V value) {
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // {a: [(b, probability_ab)]}
        List<Pair<Integer, Double>>[] graph = new List[n];
        // (the probability to reach u, u)
        Queue<Pair<Double, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.key(), a.key()));

        maxHeap.offer(new Pair<>(1.0, start));
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; ++i) {
            final int u = edges[i][0];
            final int v = edges[i][1];
            final double prob = succProb[i];
            graph[u].add(new Pair<>(v, prob));
            graph[v].add(new Pair<>(u, prob));
        }

        while (!maxHeap.isEmpty()) {
            final double prob = maxHeap.peek().key();
            final int u = maxHeap.poll().value();
            if (u == end) return prob;
            if (seen[u]) continue;
            seen[u] = true;
            for (Pair<Integer, Double> node : graph[u]) {
                final int nextNode = node.key();
                final double edgeProb = node.value();
                if (seen[nextNode]) continue;
                maxHeap.add(new Pair<>(prob * edgeProb, nextNode));
            }
        }

        return 0;
    }

    public double maxProbability2(int n, int[][] edges, double[] succProb, int start, int end) {
        // {a: [(b, probability_ab)]}
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        // (the probability to reach u, u)
        Queue<Pair<Double, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.key(), a.key()));

        maxHeap.offer(new Pair<>(1.0, start));
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; ++i)
            graph.put(i,new ArrayList<>());

        for (int i = 0; i < edges.length; ++i) {
            final int u = edges[i][0];
            final int v = edges[i][1];
            final double prob = succProb[i];
            graph.get(u).add(new Pair<>(v, prob));
            graph.get(v).add(new Pair<>(u, prob));
        }

        while (!maxHeap.isEmpty()) {
            final double prob = maxHeap.peek().key();
            final int u = maxHeap.poll().value();
            if (u == end) return prob;
            if (seen[u]) continue;
            seen[u] = true;
            for (Pair<Integer, Double> node : graph.get(u)) {
                final int nextNode = node.key();
                final double edgeProb = node.value();
                if (seen[nextNode]) continue;
                maxHeap.add(new Pair<>(prob * edgeProb, nextNode));
            }
        }

        return 0;
    }
}