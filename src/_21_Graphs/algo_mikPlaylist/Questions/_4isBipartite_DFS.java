package _21_Graphs.algo_mikPlaylist.Questions;

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
         * For each vertex, if it is not coloring/coloured yet, we will explore it using a DFS
         * In DFS, we will keep on marking the next node with diff colour if it's not coloring yet
         * But if it is coloring it has to be diff colour or there will be a clash on what to color
         * Hence, graph would not be bipartite
         * Note:
         * If it was a directed graph, the concept to solve would be way differ like multiSourceBFS approach
         * There can be multiple cycles and all of them has to be of odd Length
         * =================== FOCUS ON ODD CYCLE DETECTED OR NOT ===================
         *  */
        int nV = adj.size();
        int[] coloring = new int[nV];
        Arrays.fill(coloring, -1); // means no vertex is painted yet

        for (int i = 0; i < nV; i++) {
            if (coloring[i] == -1) {
                if (sameColourDetected(i, 1, adj, coloring)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean sameColourDetected(int u, int colour, ArrayList<ArrayList<Integer>> adj, int[] coloring) {
        coloring[u] = colour;

        for (Integer v : adj.get(u)) {
            if (coloring[v] == coloring[u]) {
                return true;
            }
            if (coloring[v] == -1 && sameColourDetected(v, 1 - colour, adj, coloring)) {
                return true;
            }
        }
        return false;
    }
}