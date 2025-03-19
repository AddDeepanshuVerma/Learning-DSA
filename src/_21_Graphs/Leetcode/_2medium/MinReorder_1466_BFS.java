package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MinReorder_1466_BFS {
    private HashMap<Integer, List<int[]>> adj;

    public int minReorder(int n, int[][] connections) {
        adj = new HashMap<>();
        for (int[] connection : connections) {
            int u = connection[0], v = connection[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, 1});// given edge
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, 0});// added edge
        }

        ArrayDeque<int[]> q = new ArrayDeque<>(); // {node, parent}
        int start = 0, count = 0;
        q.offer(new int[]{start, -1});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], parent = poll[1];

            for (int[] next : adj.getOrDefault(u, Collections.emptyList())) {
                int v = next[0], vw = next[1];
                if (v == parent) continue;// not exploring the parent again
                count += vw;
                q.offer(new int[]{v, u});
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var obj = new MinReorder_1466_BFS();
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(obj.minReorder(n, connections));
    }
}