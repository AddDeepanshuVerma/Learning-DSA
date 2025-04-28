package _21_Graphs.Leetcode._3hard;

import java.util.*;

class FindAnswer_3123_optimal {
    public static boolean[] findAnswer(int n, int[][] edges) {
        int source = 0, destination = n - 1;
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // u -> list.of{v, w, index}
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];

            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w, i});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w, i});
        }

        int[] src = dijkstra(source, adj, n);
        int[] dst = dijkstra(destination, adj, n);

        boolean[] ans = new boolean[edges.length];
        int minWeight = src[destination];
        if (minWeight == Integer.MAX_VALUE) return ans;

        System.out.println("src = " + Arrays.toString(src));
        System.out.println("dst = " + Arrays.toString(dst));

        for (int i = 0; i < ans.length; i++) {
            int a = edges[i][0], b = edges[i][1], w = edges[i][2];
            if (src[a] == Integer.MAX_VALUE || src[b] == Integer.MAX_VALUE) continue;
            ans[i] = (src[a] + w + dst[b]) == minWeight || (dst[a] + w + src[b]) == minWeight;
        }

        return ans;
    }

    private static int[] dijkstra(int src, HashMap<Integer, List<int[]>> adj, int nv) {
        int[] weight = new int[nv];
        Arrays.fill(weight, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        weight[src] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], uw = poll[1];

            if (uw < weight[u]) continue;

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], vw = ngbr[1];

                if (uw + vw < weight[v]) {
                    weight[v] = uw + vw;
                    pq.offer(new int[]{v, weight[v]});
                }
            }
        }

        return weight;
    }

    public static void main(String[] args) {
        int n = 21;
        int[][] edges = {{19, 0, 10}, {5, 20, 3}, {8, 18, 5}, {6, 5, 17}, {12, 9, 15}, {19, 20, 10}, {17, 15, 22}, {6, 4, 14}, {10, 11, 20}, {1, 18, 6}};
        boolean[] ans = findAnswer(n, edges);
        System.out.println(Arrays.toString(ans));
    }
}