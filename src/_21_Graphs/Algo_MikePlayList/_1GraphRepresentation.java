package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _1GraphRepresentation {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 3}, {1, 4}, {4, 0}, {2, 4}, {2, 3}};
        int[][] adjacencyMatrix = createAdjacencyMatrix(n, edges);
        var adjacencyLists = createAdjacencyLists(n, edges);

        System.out.println("adjacencyMatrix = " + Arrays.deepToString(adjacencyMatrix));
        System.out.println("adjacencyLists = " + adjacencyLists);
    }

    // SC : v^2, hence not optimal to use
    private static int[][] createAdjacencyMatrix(int n, int[][] edges) {
        int[][] adjMatrix = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u][v] = 1;
        }
        return adjMatrix;
    }

    // SC : v + e, hence optimal to use
    private static HashMap<Integer, List<Integer>> createAdjacencyLists(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjL = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjL.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
        }
        return adjL;
    }
}
