package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.List;

class _8AllPathsSourceTarget_797_2 {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src = 0, target = graph.length - 1;
        dfs(src, target, new ArrayList<Integer>(List.of(0)), graph);
        return ans;
    }

    private void dfs(int curr, int target, ArrayList<Integer> path, int[][] graph) {
        if (curr == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int v : graph[curr]) {
            path.add(v);
            dfs(v, target, path, graph);
            path.removeLast();
        }

    }
}