package _21_Graphs.Leetcode._3hard;

import java.util.*;

class FindMinHeightTrees_310_3 {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        int[] degree = new int[n];

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
            degree[u]++;
            degree[v]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                q.offer(i);
                degree[i]--;
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;

            while (size-- > 0) {
                int u = q.removeFirst();
                for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                    degree[v]--;
                    if (degree[v] == 1) {
                        q.offer(v);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};
        List<Integer> ans = findMinHeightTrees(n, edges);
        System.out.println("ans = " + ans);
    }
}