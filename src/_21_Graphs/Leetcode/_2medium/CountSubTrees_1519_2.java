package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class CountSubTrees_1519_2 {

    private HashMap<Integer, List<Integer>> adj;

    public int[] _10countSubTrees(int n, int[][] edges, String labels) {
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        int[] ans = new int[n];
        int src = 0, parent = -1;
        dfs(src, parent, labels.toCharArray(), ans);
        return ans;
    }

    private int[] dfs(int u, int parent, char[] arr, int[] ans) {
        int[] freq = new int[26];
        freq[arr[u] - 'a']++;

        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parent) {
                int[] child = dfs(v, u, arr, ans);
                combine(child, freq);
            }
        }

        ans[u] = freq[arr[u] - 'a'];
        return freq;
    }

    private void combine(int[] child, int[] freq) {
        for (int i = 0; i < child.length; i++) {
            freq[i] += child[i];
        }
    }
}