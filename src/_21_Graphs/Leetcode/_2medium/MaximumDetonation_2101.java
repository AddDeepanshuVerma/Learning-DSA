package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MaximumDetonation_2101 {
    public int maximumDetonation(int[][] bombs) {
        int nv = bombs.length;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < bombs.length; i++) {
            for (int j = i + 1; j < bombs.length; j++) {
                double l = Math.abs(bombs[i][0] - bombs[j][0]);
                double b = Math.abs(bombs[i][1] - bombs[j][1]);
                double distance = Math.sqrt((l * l) + (b * b));

                if (bombs[i][2] >= distance) adj.computeIfAbsent(i, list -> new ArrayList<>()).add(j);
                if (bombs[j][2] >= distance) adj.computeIfAbsent(j, list -> new ArrayList<>()).add(i);
            }
        }

        // now we need to run dfs from each node & store the max we get
        int ans = 1;
        for (int i = 0; i < nv; i++) {
            ans = Math.max(ans, dfs(i, adj, new boolean[nv]));
        }

        return ans;
    }

    private int dfs(int u, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        int count = 1;

        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (visited[v]) continue;
            count += dfs(v, adj, visited);
        }

        return count;
    }
}