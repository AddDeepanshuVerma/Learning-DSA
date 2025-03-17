package _21_Graphs.Leetcode._2medium;

import jdk.jfr.Description;

import java.util.*;

class MinScore_2492_2CustomBFS {
    @Description(" Given one path will always be there, hence simply traverse all the node and the minimum answer found at anyWhere will be ans")
    public int minScore(int n, int[][] roads) {
        int src = 1;
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // {u -> {(v, d),()...}}
        for (int[] road : roads) {
            int u = road[0], v = road[1], d = road[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, d});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, d});
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(src);
        visited[src] = true;
        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], d = ngbr[1];
                ans = Math.min(ans, d); // have to write first as we want all edges to be covered even those whole leads to visited nodes

                if (visited[u]) continue;
                visited[u] = true;
                q.offer(v);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        var obj = new MinScore_2492_2CustomBFS();
        System.out.println(obj.minScore(n, roads));
    }
}