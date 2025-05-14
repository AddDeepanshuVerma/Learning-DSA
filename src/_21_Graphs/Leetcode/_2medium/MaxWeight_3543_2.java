package _21_Graphs.Leetcode._2medium;

import java.util.*;

// here wave type BFS would not work as we can reach a target node with same weight from multiple sources
// hence we also need to consider edges while keeping the HashSet as to verify already visited nodes.
class MaxWeight_3543_2 {
    public static int maxWeight(int n, int[][] edges, int k, int t) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        int ans = Integer.MIN_VALUE;
        ArrayDeque<Trio> q = new ArrayDeque<>();
        HashSet<Trio> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Trio trio = new Trio(i, 0, 0);
            q.offer(trio);
            visited.add(trio);
        }

        while (!q.isEmpty()) {
            Trio poll = q.poll();
            int u = poll.node, edge = poll.edges, pathSum = poll.pathSum;
            if (edge == k) {
                ans = Math.max(ans, pathSum);
                continue;
            }

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], vW = ngbr[1];
                Trio next = new Trio(v, edge + 1, pathSum + vW);
                if (pathSum + vW < t && visited.add(next)) {
                    q.offer(next);
                }
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    record Trio(int node, int edges, int pathSum) {

    }

    public static void main(String[] args) {
        int n = 5, k = 3, t = 6;
        int[][] edges = {{0, 1, 1}, {0, 2, 3}, {1, 3, 2}, {2, 3, 3}, {3, 4, 1}};
        int ans = maxWeight(n, edges, k, t);
        System.out.println("ans = " + ans);
    }
}