package _21_Graphs.Leetcode._2medium;

import java.util.HashMap;
import java.util.HashSet;

class MaximalNetworkRank_1615_2 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();

        for (int[] road : roads) {
            int u = road[0], v = road[1];
            degree[u]++;
            degree[v]++;
            adj.computeIfAbsent(u, set -> new HashSet<>()).add(v);
            adj.computeIfAbsent(v, set -> new HashSet<>()).add(u);
        }

        int max = 0;
        for (int i = 0; i < degree.length; i++) {
            for (int j = i + 1; j < degree.length; j++) {
                if (isNeighbour(i, j, adj)) {
                    max = Math.max(max, degree[i] + degree[j] - 1);
                } else {
                    max = Math.max(max, degree[i] + degree[j]);
                }
            }
        }

        return max;
    }

    private boolean isNeighbour(int a, int b, HashMap<Integer, HashSet<Integer>> adj) {
        return !adj.isEmpty() && adj.containsKey(a) && adj.get(a).contains(b);
    }
}