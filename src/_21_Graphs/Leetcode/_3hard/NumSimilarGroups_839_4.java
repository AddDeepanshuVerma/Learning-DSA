package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.*;

@Description("Using BFS")
class NumSimilarGroups_839_4 {

    public int numSimilarGroups(String[] strs) {
        int nv = strs.length;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSame(strs[i], strs[j])) {
                    adj.computeIfAbsent(i, list -> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, list -> new ArrayList<>()).add(i);
                }
            }
        }

        boolean[] visited = new boolean[nv];
        int components = 0;
        for (int node = 0; node < nv; node++) {
            if (!visited[node]) {
                // run DFS/BFS on all node from this node
                dfs(node, visited, adj);
                bfs(node, visited, adj);
                components++;
            }
        }

        return components;
    }

    private void bfs(int node, boolean[] visited, HashMap<Integer, List<Integer>> adj) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }

    }

    private void dfs(int curr, boolean[] visited, HashMap<Integer, List<Integer>> adj) {
        visited[curr] = true;

        for (Integer v : adj.getOrDefault(curr, Collections.emptyList())) {
            if (!visited[v]) {
                dfs(v, visited, adj);
            }
        }
    }

    private boolean isSame(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++count > 2) return false;
            }
        }

        return count == 0 || count == 2;
    }
}