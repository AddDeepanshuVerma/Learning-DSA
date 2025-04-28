package _21_Graphs.Leetcode._2medium;

import java.util.*;

class _5ValidPath_1971_BFS {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int u = q.removeFirst();
            if (u == destination) return true;

            for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.addLast(v);
                }
            }
        }

        return false;
    }
}