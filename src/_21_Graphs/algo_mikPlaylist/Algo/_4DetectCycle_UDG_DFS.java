package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.ArrayList;

public class _4DetectCycle_UDG_DFS {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        /* KeyPoints :
         * 1. As it is an UDG, we need to make sure that parent first of curr first does not prove to be a cycle
         * hence maintain a Parent NODE
         * */
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            int parent = -1;
            if (!visited[i] && cycleDetected(i, adj, visited, parent)) {
                return true;
            }
        }
        return false;
    }

    private boolean cycleDetected(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[curr] = true;

        for (Integer next : adj.get(curr)) {
            if (next == parent) continue;
            if (visited[next]) return true;
            if (cycleDetected(next, adj, visited, curr)) {
                return true;
            }
        }
        return false;
    }
}
