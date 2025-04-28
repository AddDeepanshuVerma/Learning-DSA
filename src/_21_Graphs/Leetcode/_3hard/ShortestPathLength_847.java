package _21_Graphs.Leetcode._3hard;

import java.util.HashMap;

//26 / 54 testcases passed
class ShortestPathLength_847 {
    int len;
    private int nv;
    private int max;

    public int shortestPathLength(int[][] graph) {
        len = Integer.MAX_VALUE;
        nv = graph.length;
        max = 0;
        for (int[] arr : graph) max = Math.max(max, arr.length);

        HashMap<Integer, Integer> visited;
        for (int i = 0; i < nv; i++) {
            visited = new HashMap<>();
            visited.merge(i, 1, Integer::sum);
            dfs(i, 0, visited, graph);
        }
        return len;
    }

    private void dfs(int curr, int move, HashMap<Integer, Integer> visited, int[][] graph) {
        if (visited.size() == nv) {
            len = Math.min(len, move);
            return;
        }

        for (int v : graph[curr]) {
            if (visited.getOrDefault(v, 0) < max) {
                visited.merge(v, 1, Integer::sum);
                dfs(v, move + 1, visited, graph);
                if (visited.merge(v, -1, Integer::sum) == 0) visited.remove(v);
            }
        }
    }

    public static void main(String[] args) {
        var obj = new ShortestPathLength_847();
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(obj.shortestPathLength(graph));
    }
}