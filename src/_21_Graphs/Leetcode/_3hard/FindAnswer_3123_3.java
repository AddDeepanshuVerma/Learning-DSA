package _21_Graphs.Leetcode._3hard;

import java.util.*;

//  535 / 536 testcases passed ::: HashMap + dijkstra with PriorityQueue
class FindAnswer_3123_3 {
    public static boolean[] findAnswer(int n, int[][] edges) {
        int src = 0, dst = n - 1;
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // u -> list.of{v, w, index}
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];

            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w, i});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w, i});
        }

        int[] min = new int[n];
        Arrays.fill(min, (int) 1e8);
        min[src] = 0;

        HashMap<Integer, HashSet<Integer>> paths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            paths.put(i, new HashSet<>());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // node, weight
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
                    // we are using priorityQueue hence we have to explore the best one
                    paths.put(v, new HashSet<>(paths.get(u)));
                    pq.offer(new int[]{v, min[v]});
                } else if (uw + vw == min[v]) {
                    // this equal possibility says that due to priority queue we have to gone far from uw + vw hence
                    // next node will be explored together with < and <= possibility
                    for (Integer val : paths.get(u)) {
                        paths.get(v).add(val);
                    }
                }
                paths.get(v).add(idx);
            }
        }

        boolean[] ans = new boolean[edges.length];
        if (min[dst] == Integer.MAX_VALUE) return ans;

        for (Integer idx : paths.get(dst)) {
            ans[idx] = true;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1, 4}, {0, 2, 1}, {1, 3, 2}, {1, 4, 3}, {1, 5, 1}, {2, 3, 1}, {3, 5, 3}, {4, 5, 2}};
        boolean[] ans = findAnswer(n, edges);
        System.out.println(Arrays.toString(ans));
    }
}