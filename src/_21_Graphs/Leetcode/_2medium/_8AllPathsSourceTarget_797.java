package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class _8AllPathsSourceTarget_797 {

    private List<List<Integer>> ans;
    private HashMap<Integer, List<Integer>> adj;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int nv = graph.length;
        int src = 0, target = nv - 1;
        ans = new ArrayList<>();
        adj = new HashMap<>();
        for (int u = 0; u < graph.length; u++) {
            for (int j = 0; j < graph[u].length; j++) {
                adj.computeIfAbsent(u, val -> new ArrayList<>()).add(graph[u][j]);
            }
        }

        dfs(src, target, new ArrayList<Integer>(List.of(0)));
        return ans;
    }

    private void dfs(int curr, int target, ArrayList<Integer> path) {
        if (curr == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (Integer v : adj.getOrDefault(curr, Collections.emptyList())) {
            path.add(v);
            dfs(v, target, path);
            path.removeLast();
        }
    }
}