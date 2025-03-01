package _21_Graphs.Leetcode;

import java.util.*;

class _8plementDijkstra {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(src, 0));
        ans[src] = 0;

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int u = poll.node;
            int w = poll.weight;

            for (int v : adj.get(u)) {
                if (w + 1 < ans[v]) { // all nodes have same weight == 1
                    ans[v] = w + 1;
                    q.offer(new Pair(v, w + 1));
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        return ans;
    }

    static record Pair(Integer node, Integer weight) {
    }

}