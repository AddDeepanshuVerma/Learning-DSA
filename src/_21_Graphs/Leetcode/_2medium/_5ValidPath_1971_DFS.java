package _21_Graphs.Leetcode._2medium;

import java.util.*;

class _5ValidPath_1971_DFS {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }
        return dfs(source, destination, adj, visited);
    }

    private boolean dfs(int curr, int target, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        if (curr == target) return true;
        if (visited[curr]) return false;
        visited[curr] = true;

        for (int v : adj.getOrDefault(curr, Collections.emptyList())) {
            if (dfs(v, target, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}