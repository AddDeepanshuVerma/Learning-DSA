package _21_Graphs.Algo_MikePlayList;

import java.util.*;

public class _14Dijkstra_Shortest_Path_print {

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new Pair(v, w));
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new Pair(u, w));
        }

        // we need to find the shortest path weight from 1 -> n
        int[] pathWeight = new int[n + 1];
        Arrays.fill(pathWeight, Integer.MAX_VALUE);
        int[] parent = new int[n + 1];

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int source = 1, target = n;
        q.offer(new Pair(source, 0));
        pathWeight[source] = 0;
        parent[source] = source;

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int u = poll.node;
            int w = poll.weight;

            for (Pair pair : adj.getOrDefault(u, Collections.emptyList())) {
                int v = pair.node;
                int delta = pair.weight;
                if (w + delta < pathWeight[v]) { // got a better option
                    pathWeight[v] = w + delta;
                    parent[v] = u;
                    q.offer(new Pair(v, w + delta));
                }
            }
        }

        if (pathWeight[target] == Integer.MAX_VALUE) { // no path was there bw source and target
            return List.of(-1);
        }
        // we got the shortest path now lets get path node by node
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int temp = target;
        while (parent[temp] != temp) {
            stack.push(temp);
            temp = parent[temp];
        }
        // when condition broke, we left without putting the last/source node
        stack.push(source);

        // now let's prepare our answer as per problem requirements
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }

    record Pair(Integer node, Integer weight) {
    }
}


