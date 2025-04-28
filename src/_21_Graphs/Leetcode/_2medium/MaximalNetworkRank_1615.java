package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MaximalNetworkRank_1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                max = Math.max(max, bfs(n, i, adj, visited));
            }
        }
        return max;
    }

    private static int bfs(int n, int src, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(src);
        visited[src] = true;

        int max = adj.get(0).size();
        while (!q.isEmpty()) {
            int u = q.poll();
            int uSize = adj.get(u).size();

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                int vSize = adj.get(v).size();
                max = Math.max(max, uSize + vSize - 1);
                if (visited[v]) continue;
                visited[v] = true;
                q.offer(v);
            }
        }
        return max;
    }
}