package _21_Graphs.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class _4isBipartite_DFS {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        /*
         * KeyPoints:
         * It is an unDirected Graph & yes there can be cycles in it.
         * Approach :
         * Here we know that we need tom divide this graph in 2 diff groups hence will do the same using colours
         * Steps:
         * For each vertex, if it is not visited/coloured yet, we will explore it using a DFS
         * In DFS, we will keep on marking the next node with diff colour if it's not visited yet
         * But if it is visited it has to be diff colour or there will be a clash on what to color
         * Hence, graph would not be bipartite
         * Note:
         * If it was a directed graph, the concept to solve would be way differ like multiSourceBFS approach
         * There can be multiple cycles and all of them has to be of odd Length
         * =================== FOCUS ON ODD CYCLE DETECTED OR NOT ===================
         *  */
        int vertices = adj.size();
        int[] visited = new int[vertices];
        Arrays.fill(visited, -1); // means no vertex is painted yet

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == -1) {
                if (oddCycleFound(i, 1, adj, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean oddCycleFound(int u, int colour, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[u] = colour;

        for (Integer v : adj.get(u)) {
            if (visited[v] == visited[u]) {
                return true;
            }
            if (visited[v] == -1 && oddCycleFound(v, 1 - colour, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}