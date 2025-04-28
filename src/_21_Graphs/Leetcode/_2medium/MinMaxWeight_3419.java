package _21_Graphs.Leetcode._2medium;

import java.util.*;

class MinMaxWeight_3419 {
    public static int minMaxWeight(int n, int[][] edges, int threshold) {
        int[] indegree = new int[n];
        int[] outGoing = new int[n];

        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // {u -> {v, w}...}
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
            indegree[v]++;
        }

        boolean[] visited = new boolean[n];
        List<Integer> topo = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // stores {reached node, maxWeight so far, parent Node}
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                pq.offer(new int[]{i, 0, -1});
            }
        }
        int maxWeight = -1;
        int maxOutgoing = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], w = poll[1], parent = poll[2];
            if (visited[u]) continue;

            visited[u] = true;
            topo.add(u);
            maxWeight = Math.max(maxWeight, w);
            if (parent != -1) {
                maxOutgoing = Math.max(maxOutgoing, ++outGoing[parent]);
            }
            if (u == 0) break;

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], vw = ngbr[1];
                indegree[v]--;
                if (indegree[v] == 0) {
                    pq.offer(new int[]{v, vw, u});
                }
            }

        }

        return maxOutgoing > threshold || topo.size() != n || topo.get(topo.size() - 1) != 0 ? -1 : maxWeight;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2, 1}, {1, 3, 3}, {1, 4, 5}, {2, 3, 2}, {3, 4, 2}, {4, 0, 1}};
        int threshold = 1;

        int ans = minMaxWeight(n, edges, threshold);
        System.out.println("ans = " + ans);
    }

}