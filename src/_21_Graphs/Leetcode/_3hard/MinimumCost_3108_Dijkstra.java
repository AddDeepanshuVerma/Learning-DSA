package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.*;

@Description("Below approach does not work")
class MinimumCost_3108_Dijkstra {

    private HashMap<Integer, List<int[]>> adj;
    private static final int MASK = (1 << 31) - 1;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // stores: {u -> v, w}
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, w});
        }

        int[] ans = new int[query.length];
        for (int i = 0; i < ans.length; i++) {
            int start = query[i][0], dst = query[i][1];
            ans[i] = dijkstraAlgo(n, start, dst);
        }
        return ans;
    }

    private int dijkstraAlgo(int n, int start, int dst) {
        int[] weight = new int[n];
        Arrays.fill(weight, MASK);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]); // stores : {curr node, it's Weight}

        q.offer(new int[]{start, MASK});
        weight[start] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], uw = poll[1];

            for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                int v = ngbr[0], vw = ngbr[1];
                if (weight[v] == 0) continue;
                int updatedWeight = uw & vw;
                if (updatedWeight < weight[v]) {
                    weight[v] = (uw & vw);
                    q.offer(new int[]{v, uw & vw});
                }
            }
        }
//        System.out.print("for query : " + start + " " + dst);
//        System.out.println(", getValue array :" + Arrays.toString(getValue));
        return weight[dst] == MASK ? -1 : weight[dst];
    }

    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
//        int[][] query = {{0, 3}, {3, 4}};
        int n = 3;
        int[][] edges = {{0, 2, 7}, {0, 1, 15}, {1, 2, 6}, {1, 2, 1}};
        int[][] query = {{1, 2}};

        var obj = new MinimumCost_3108_Dijkstra();
        int[] ans = obj.minimumCost(n, edges, query);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}