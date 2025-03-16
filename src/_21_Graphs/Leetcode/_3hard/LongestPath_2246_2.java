package _21_Graphs.Leetcode._3hard;

import java.util.*;

class LongestPath_2246_2 {

    private int res;

    public int longestPath(int[] parent, String s) {
        int nv = parent.length;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            int u = i, v = parent[i];
//            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u); // in Tree type graph only parent->child relationship is needed
        }

        res = 1;
        int src = 0, parentNode = -1;
        dfs(src, parentNode, s.toCharArray(), adj);
        return res;
    }

    private int dfs(int u, int parentNode, char[] arr, HashMap<Integer, List<Integer>> adj) {
        int max1 = 0, max2 = 0;

        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parentNode) {
                int res = dfs(v, u, arr, adj);
                if (arr[u] == arr[v]) continue;

                if (res > max1) {
                    max2 = max1;
                    max1 = res;
                } else if (res > max2) {
                    max2 = res;
                }
            }
        }

        res = Math.max(res, max1 + max2 + 1);
        return max1 + 1;
    }
}