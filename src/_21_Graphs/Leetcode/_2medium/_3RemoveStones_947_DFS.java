package _21_Graphs.Leetcode._2medium;

import java.util.*;

class _3RemoveStones_947_DFS {
    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        int nV = stones.length;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int u = 0; u < nV; u++) {
            for (int v = u + 1; v < nV; v++) {
                int[] X = stones[u];
                int[] Y = stones[v];
                if (X[0] == Y[0] || X[1] == Y[1]) {
                    graph.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
                    graph.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
                }
            }
        }

        // now we need to find out no of islands in this 2D plane
        HashSet<Integer> visited = new HashSet<>();
        int numOfIslands = 0;
        for (int i = 0; i < nV; i++) {
            if (visited.add(i)) {
                dfs(i, graph, visited);
                numOfIslands++;
            }
        }

        return nV - numOfIslands;
    }

    private static void dfs(int curr, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited) {
        for (int next : graph.getOrDefault(curr, Collections.emptyList())) {
            if (visited.add(next)) { // if next node is not visited yet, then add it to visited and explore it
                dfs(next, graph, visited);
            }
        }
    }
}