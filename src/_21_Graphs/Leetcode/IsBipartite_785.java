package _21_Graphs.Leetcode;

import java.util.*;

class IsBipartite_785 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2},};
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        /*
         * Bipartite : No adj nodes can be of same colour
         * Hence only when there is cycle, we can get stuck on this situation
         * like: if cycle length is even, colour can go in alternate way
         *       but if cycle length is odd, same colour will meet at the end.
         *
         * Approach: run a DFS/BFS from wny node, maintain a visited array
         *           if we evey encounter a node which was already visited and has same colour as current node
         *           means: cycle was detected with odd length else keep exploring
         * */

        int n = graph.length;
        HashMap<Integer, List<Integer>> adj = new HashMap<>(); // to keep adj lists

        for (int i = 0; i < graph.length; i++) {
            int u = i;
            for (int j = 0; j < graph[i].length; j++) {
                int v = graph[i][j];
                adj.computeIfAbsent(i, val -> new ArrayList<>()).add(v);
                adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
            }
        }
        int[] visited = new int[n]; // -1 ~ not visited, 0 ~ yellow, 1 ~ red
        Arrays.fill(visited, -1);
        int currColour = 0;

        for (int i = 0; i < n; i++) {
                if (visited[i] == -1 && gotOddCycle(i, currColour, adj, visited)) {
                    return false;
            }
        }
        return true;
    }

    private static boolean gotOddCycle(int node, int currColour, HashMap<Integer, List<Integer>> adj, int[] visited) {
        visited[node] = currColour;

        for (int next : adj.getOrDefault(node, Collections.emptyList())) {
            if (visited[next] == -1) {
                if (gotOddCycle(next, currColour ^ 1, adj, visited)) {
                    return true;
                }
            } else if (visited[next] == currColour) {
                return true;
            }
        }
        return false;
    }
}