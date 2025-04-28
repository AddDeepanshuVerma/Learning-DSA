package _21_Graphs.Leetcode._2medium;

import java.util.*;

class FindCheapestPrice_787_BFS {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // in this BFS approach as we are going through waves hence we will do size type bfs search
        // make the graph
        HashMap<Integer, List<int[]>> adj = new HashMap<>(); // {u, {(v, w),(v, w),...}}
        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
        }

        //now implement dijkstra algorithm but with waves wise and using normal Queue
        ArrayDeque<int[]> q = new ArrayDeque<>(); //{node, weight to reach this node using its own path}
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);

        q.offer(new int[]{src, 0});
        weight[src] = 0;
        int stops = 0;

        while (!q.isEmpty() && stops <= k) { // we will keep on expanding waves till they are less than demanded
            int size = q.size();

            while (size-- > 0) {
                int[] poll = q.poll();
                int u = poll[0], uw = poll[1];

                for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
                    int v = ngbr[0], delta = ngbr[1];
                    if (uw + delta < weight[v]) {
                        weight[v] = uw + delta;
                        q.offer(new int[]{v, weight[v]});
                    }
                }
            }
            stops++;// now in this above wave all those elements will be added, who are result of these many stops
        }

        return weight[dst] == Integer.MAX_VALUE ? -1 : weight[dst];
    }

    public static void main(String[] args) {
        var obj = new FindCheapestPrice_787_BFS();
        int n = 5, src = 0, dst = 2, stops = 2;
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, stops));
    }
}