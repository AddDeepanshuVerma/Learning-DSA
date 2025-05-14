package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MaxWeight_3543 {
    public int maxWeight(int n, int[][] edges, int k, int t) {
        /*
        The path contains exactly k edges.
        The total sum of edge weights in the path is strictly less than t.
        */

        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], list -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        int ans = Integer.MIN_VALUE;
        ArrayDeque<Trio> q = new ArrayDeque<>();
        HashSet<Trio> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Trio node = new Trio(i, 0, 0);
            q.offer(node);
            visited.add(node);
        }

        while (!q.isEmpty()) {
            Trio poll = q.poll();
            if (poll.edges == k) {
                ans = Math.max(ans, poll.pathSum);
                continue;
            }

            for (int[] ngbr : adj.getOrDefault(poll.node, Collections.emptyList())) {
                Trio next = new Trio(ngbr[0], poll.edges + 1, poll.pathSum + ngbr[1]);
                if (poll.pathSum + ngbr[1] < t && visited.add(next)) {
                    q.offer(next);
                }
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    record Trio(int node, int edges, int pathSum) {

    }
}