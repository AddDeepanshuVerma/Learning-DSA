package _21_Graphs.Leetcode._2medium;

import java.util.*;

// 199ms : Topological sort + TreeSet -> ArrayList conversion
class GetAncestors_2192 {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inDegree = new int[n];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            inDegree[v]++;
        }

        List<TreeSet<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) ans.add(new TreeSet<Integer>());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            TreeSet<Integer> src = ans.get(u);

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                inDegree[v]--;
                TreeSet<Integer> dest = ans.get(v);
                dest.addAll(new ArrayList<>(src));
                dest.add(u);
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (TreeSet<Integer> item : ans) res.add(new ArrayList<>(item));
        return res;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        List<List<Integer>> ans = getAncestors(n, edges);
        System.out.println("ans = " + ans);
    }
}