package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MinReorder_1466_DFS_2 {

    private List<List<int[]>> adj;

    public int minReorder(int n, int[][] connections) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] connection : connections) {
            int u = connection[0], v = connection[1];
            adj.get(u).add(new int[]{v, 1});// given edge
            adj.get(v).add(new int[]{u, 0});// added edge
        }

        int start = 0, parent = -1;
        return dfs(start, parent);
    }

    private int dfs(int u, int parent) {
        int count = 0;
        for (int[] next : adj.get(u)) {
            int v = next[0], vw = next[1];
            if (v == parent) continue; // not exploring backSide again
            count += vw + dfs(v, u);
        }
        return count;
    }
}