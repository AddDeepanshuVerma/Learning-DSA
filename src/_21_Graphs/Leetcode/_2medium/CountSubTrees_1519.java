package _21_Graphs.Leetcode._2medium;

import java.util.*;

class CountSubTrees_1519 {

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
        dfs(src, parent, labels, ans);
        return ans;
    }

    private int[] dfs(int u, int parent, String labels, int[] ans) {
        int[] freq = new int[26];
        freq[labels.charAt(u) - 'a']++;

        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parent) {
                int[] child = dfs(v, u, labels, ans);
                combine(child, freq);
            }
        }

        ans[u] = freq[labels.charAt(u) - 'a'];
        return freq;
    }

    private void combine(int[] child, int[] freq) {
        for (int i = 0; i < child.length; i++) {
            freq[i] += child[i];
        }
    }
}