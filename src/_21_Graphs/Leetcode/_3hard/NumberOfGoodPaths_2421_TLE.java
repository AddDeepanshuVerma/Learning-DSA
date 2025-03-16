package _21_Graphs.Leetcode._3hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// TC : O(n^2)
class NumberOfGoodPaths_2421_TLE {

    private HashMap<Integer, List<Integer>> adj;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        int nv = vals.length;
        int count = 0;
        for (int i = 0; i < nv; i++) {
            int parent = -1;
            count += dfs(i, parent, i, vals) - 1;
        }
        return (count >> 1) + nv;
    }

    private int dfs(int u, int parent, int src, int[] vals) {
        int count = 0;
        if (vals[u] == vals[src]) count++;
        if (vals[u] > vals[src]) return 0;

        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v == parent) continue;
            count += dfs(v, u, src, vals);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] vals = {1, 3, 2, 1, 3};
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        var obj = new NumberOfGoodPaths_2421_TLE();
        System.out.println(obj.numberOfGoodPaths(vals, edges));
    }
}