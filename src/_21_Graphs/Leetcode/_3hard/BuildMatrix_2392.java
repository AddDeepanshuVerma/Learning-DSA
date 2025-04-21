package _21_Graphs.Leetcode._3hard;

import java.util.*;

class BuildMatrix_2392 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row = topologicalSort(k, rowConditions);
        if (row.isEmpty()) return new int[][]{};
        List<Integer> col = topologicalSort(k, colConditions);
        if (col.isEmpty()) return new int[][]{};

        int[][] grid = new int[k][k];
        for (int i = 0; i < k; i++) {
            Arrays.fill(grid[i], row.get(i));
        }

        for (int r = 0; r < k; r++) {
            int val = col.get(r);
            for (int c = 0; c < k; c++) {
                if (grid[c][r] != val) {
                    grid[c][r] = 0;
                }
            }
        }

        return grid;
    }

    private List<Integer> topologicalSort(int nv, int[][] edges) {
        List<Integer> ans = new ArrayList<>();

        int[] indegree = new int[nv + 1];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
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