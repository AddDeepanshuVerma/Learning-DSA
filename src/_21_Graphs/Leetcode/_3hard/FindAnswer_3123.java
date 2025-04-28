package _21_Graphs.Leetcode._3hard;

import java.util.*;

//  531 / 536 testcases passed ::: ArrayList + dijkstra without PriorityQueue
class FindAnswer_3123 {
    public static boolean[] findAnswer(int n, int[][] edges) {
        int src = 0, dst = n - 1;
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // u -> list.of{v, w, index}
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];

            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w, i});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w, i});
        }

        int[] min = new int[n];
        ArrayList<Integer>[] paths = new ArrayList[n];

        Arrays.fill(paths, new ArrayList<>());
        Arrays.fill(min, Integer.MAX_VALUE);

        min[src] = 0;

        ArrayDeque<int[]> pq = new ArrayDeque<>(); // node, weight
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0];
            int uw = poll[1];
            if (min[u] < uw) continue;

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], vw = ngbr[1], idx = ngbr[2];
                if (uw + vw > min[v]) continue;

                if (uw + vw < min[v]) {
                    min[v] = uw + vw;
                    paths[v] = new ArrayList<Integer>(paths[u]);
                }
                if (uw + vw == min[v]) {
                    paths[v].addAll(paths[u]);
                }
                paths[v].add(idx);// we are not using priorityQueue hence we have to explore each possibility, < & == both
                pq.offer(new int[]{v, min[v]});
            }
        }

        boolean[] ans = new boolean[edges.length];
        if (min[dst] == Integer.MAX_VALUE) return ans;

        for (Integer val : paths[dst]) ans[val] = true;
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1, 4}, {0, 2, 1}, {1, 3, 2}, {1, 4, 3}, {1, 5, 1}, {2, 3, 1}, {3, 5, 3}, {4, 5, 2}};
        boolean[] ans = findAnswer(n, edges);
        System.out.println(Arrays.toString(ans));
    }
}