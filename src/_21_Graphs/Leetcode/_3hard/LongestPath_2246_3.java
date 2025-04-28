package _21_Graphs.Leetcode._3hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class LongestPath_2246_3 {

    private int res = 1;

    public int longestPath(int[] parent, String s) {
        int nv = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            adj.get(parent[i]).add(i);
        }

        int src = 0, parentNode = -1;
        dfs(src, parentNode, s.toCharArray(), adj);
        return res;
    }

    private int dfs(int u, int parentNode, char[] arr, List<List<Integer>> adj) {
        int max1 = 0, max2 = 0;

        for (Integer v : adj.get(u)) {
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