package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.*;

public class _9Dijkstra_Shortest_Path_2 {

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        HashMap<Integer, List<Duo>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new Duo(v, w));
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new Duo(u, w));
        }

        // we need to find the shortest path weight from 1 -> n
        int[] weight = new int[n + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int source = 1, target = n;
        q.offer(new Pair(source, 0, new ArrayList<>(List.of(1))));

        weight[source] = 0;
        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int u = poll.node;
            int w = poll.weight;
            List<Integer> prev = poll.path;

            for (Duo duo : adj.getOrDefault(u, Collections.emptyList())) {
                int v = duo.node;
                int delta = duo.weight;
                if (w + delta < weight[v]) { // got a better option
                    weight[v] = w + delta;
                    List<Integer> curr = new ArrayList<>(List.copyOf(prev));
                    curr.add(v);
                    if (v == target) ans = curr;
                    q.offer(new Pair(v, w + delta, curr));
                }
            }
        }

        if (weight[target] == Integer.MAX_VALUE) { // no path was there bw source and target
            return List.of(-1);
        }
        // add weight at first index
        ans.add(0, weight[n]);
        return ans;
    }

    record Pair(Integer node, Integer weight, List<Integer> path) {
    }

    record Duo(Integer node, Integer weight) {
    }

}


