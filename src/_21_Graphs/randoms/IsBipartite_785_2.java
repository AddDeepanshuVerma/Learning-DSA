package _21_Graphs.randoms;

import java.util.*;

class IsBipartite_785_2 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2},};
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] visited = new int[n]; // -1 ~ not visited, 0 ~ yellow, 1 ~ red
        Arrays.fill(visited, -1);
        int currColour = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1 && gotOddCycle(i, currColour, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private static boolean gotOddCycle(int node, int currColour, int[][] graph, int[] visited) {
        visited[node] = currColour;

        for (int next : graph[node]) {
            if (visited[next] == -1) {
                if (gotOddCycle(next, currColour ^ 1, graph, visited)) {
                    return true;
                }
            } else if (visited[next] == currColour) {
                return true;
            }
        }
        return false;
    }
}