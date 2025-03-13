package _21_Graphs.Leetcode._2medium;

import java.util.*;

class _9MinTime_1443 {

    private HashSet<Integer> apple;
    private HashMap<Integer, List<Integer>> adj;
    private int timeSpend;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new HashMap<>();
        apple = new HashSet<>();
        // create our Graph
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        // create our hasSet to retrieve data in logN time
        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                apple.add(i);
            }
        }

        timeSpend = 0;
        // as pr problem we have to start with 0th node
        int src = 0, parent = -1;
        dfs(src, parent);

        return timeSpend;
    }

    private boolean dfs(int u, int parent) {
        boolean foundApple = false;
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parent && dfs(v, u)) {
                foundApple = true;
                timeSpend += 2;
            }
        }

        return foundApple || apple.contains(u);
    }

}