package _21_Graphs.Leetcode._5revision;

import java.util.*;

class ShortestDistanceAfterQueries_3243_2 {
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) adj.get(i).add(i + 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            adj.get(u).add(v);
            ans[i] = bfs(n, adj);
        }
        return ans;
    }

    private static int bfs(int n, List<List<Integer>> adj) {
        int destination = n - 1;
        boolean[] seen = new boolean[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(0);
        seen[0] = true;
        int level = 0; // stored the min time we need to reach which is already inside Queue

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int u = q.poll();
                if (u == destination) return level;

                for (Integer v : adj.get(u)) {
                    if (!seen[v]) {
                        seen[v] = true;
                        q.offer(v);
                    }
                }
            }
            level++; // which has previously been inserted in queue got there in 1 + previousLevel
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 14;
        int[][] queries = {{0, 6}, {4, 12}};
        int[] ans = shortestDistanceAfterQueries(n, queries);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}