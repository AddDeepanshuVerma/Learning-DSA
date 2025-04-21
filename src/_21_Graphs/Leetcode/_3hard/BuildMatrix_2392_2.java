package _21_Graphs.Leetcode._3hard;

import java.util.*;

class BuildMatrix_2392_2 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row = topologicalSort(k, rowConditions);
        if (row.isEmpty()) return new int[][]{};
        List<Integer> col = topologicalSort(k, colConditions);
        if (col.isEmpty()) return new int[][]{};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < col.size(); i++) map.put(col.get(i), i);

        int[][] grid = new int[k][k];
        for (int i = 0; i < row.size(); i++) {
            int val = row.get(i);
            grid[i][map.get(val)] = val;
        }

        return grid;
    }

    private List<Integer> topologicalSort(int nv, int[][] edges) {
        List<Integer> ans = new ArrayList<>();

        int[] indegree = new int[nv + 1];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            indegree[edge[1]]++;
            adj.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(edge[1]);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            ans.add(u);
            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return ans.size() == nv ? ans : new ArrayList<>();
    }
}