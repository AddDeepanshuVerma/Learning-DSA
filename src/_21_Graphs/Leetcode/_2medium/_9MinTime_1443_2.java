package _21_Graphs.Leetcode._2medium;

import java.util.*;

class _9MinTime_1443_2 {
    private HashMap<Integer, List<Integer>> adj;
    private int timeSpend;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new HashMap<>();
        // create our Graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }

        timeSpend = 0;
        // as pr problem we have to start with 0th node
        int src = 0, parent = -1;
        dfs(src, parent, hasApple);

        return timeSpend;
    }

    private boolean dfs(int u, int parent, List<Boolean> hasApple) {
        boolean foundApple = false;
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parent && dfs(v, u, hasApple)) {
                foundApple = true;
                timeSpend += 2;
            }
        }
        return foundApple || hasApple.get(u);
    }

}