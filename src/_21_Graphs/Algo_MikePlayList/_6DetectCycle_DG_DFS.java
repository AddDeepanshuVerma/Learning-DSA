package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayList;

public class _6DetectCycle_DG_DFS {
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        /*
         * Key Points : In Directed graph we can not relay on a single visited array coz:
         * 1. suppose we ran a dfs on a node and no cycle was detected but all those nodes were marked as visited so
         *    that we do not run dfs again on any of those node again to save time and iot worked in UDG because
         *    even if we visited the node which was previously visited in a previous DFS, being it UDG we can go back.
         * 2. But DG we can not go back as its single directed hence
         * 3. We need to maintain another visited array for each and every DFS called.
         *    so that we can judge the visited nodes based on current DFS only.
         * 4. Hence, two visited array will be used one globally and one for each DFS & a cycle will be detected in a DFS only if
         *    the same DFS's visited nodes were visited again also we will not explore Globally visited node as they are already done
         * */
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];
        boolean[] inRecursion = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && cycleDetected(i, inRecursion, visited, adj)) {
                return true;
            }
        }
        return false;
    }

    private boolean cycleDetected(int curr, boolean[] inRecursion, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        inRecursion[curr] = true;
        visited[curr] = true;
        for (Integer next : adj.get(curr)) {
            if (inRecursion[next]) return true;
            if (visited[next]) continue;
            if (cycleDetected(next, inRecursion, visited, adj)) return true;
        }
        inRecursion[curr] = false;
        return false;
    }

    private boolean cycleDetected2(int curr, boolean[] inRecursion, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        inRecursion[curr] = true;
        visited[curr] = true;
        for (Integer next : adj.get(curr)) {
            if (!visited[next] && cycleDetected2(next, inRecursion, visited, adj)) {
                return true;
            } else if (inRecursion[next]) // means it was visited, tho if it was also visited in recursion then cycle detected
                return true;
        }
        inRecursion[curr] = false;
        return false;
    }

}
