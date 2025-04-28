package _21_Graphs.Leetcode._3hard;

import java.util.*;

class LongestPath_2246 {

    private int res;

    public int longestPath(int[] parent, String s) {
        int nv = parent.length;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            int u = i, v = parent[i];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }

        res = 1;
        int src = 0, parentNode = -1;
        dfs(src, parentNode, s.toCharArray(), adj);
        return res;
    }

    private int dfs(int u, int parentNode, char[] arr, HashMap<Integer, List<Integer>> adj) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parentNode) {
                if (arr[u] != arr[v]) {
                    int res = 1 + dfs(v, u, arr, adj);
                    pq.add(res);
                } else {
                    dfs(v, u, arr, adj);
                }
            }
        }

        int longest1 = !pq.isEmpty() ? pq.poll() : 0;
        int longest2 = !pq.isEmpty() ? pq.poll() : 0;
        res = Math.max(res, longest1 + longest2 + 1);

        return longest1;
    }

    private int dfs2(int u, int parentNode, char[] arr, HashMap<Integer, List<Integer>> adj) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // it has to be min heap to keep max in heap
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parentNode) {
                if (arr[u] != arr[v]) {
                    int res = 1 + dfs2(v, u, arr, adj);
                    pq.add(res);
                    while (pq.size() > 2) pq.poll();
                } else {
                    dfs2(v, u, arr, adj);
                }
            }
        }

        int longest2 = !pq.isEmpty() ? pq.poll() : 0;
        int longest1 = !pq.isEmpty() ? pq.poll() : 0;
        res = Math.max(res, longest1 + longest2 + 1);

        return Math.max(longest1, longest2);
    }

    private int dfs3(int u, int parentNode, char[] arr, HashMap<Integer, List<Integer>> adj) {
        int max1 = 0, max2 = 0;

        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parentNode) {
                if (arr[u] != arr[v]) {
                    int res = 1 + dfs3(v, u, arr, adj);
                    if (res > max1) {
                        max2 = max1;
                        max1 = res;
                    } else if (res > max2) max2 = res;
                } else {
                    dfs3(v, u, arr, adj);
                }
            }
        }
        res = Math.max(res, max1 + max2 + 1);
        return max1;
    }
}