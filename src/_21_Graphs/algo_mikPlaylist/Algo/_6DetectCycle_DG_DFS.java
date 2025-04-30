package _21_Graphs.algo_mikPlaylist.Algo;

import jdk.jfr.Description;

import java.util.ArrayList;

public class _6DetectCycle_DG_DFS {
    /*
     * Key Points.js : In Directed graph we can not relay on a single visited array coz:
     * 1. suppose we ran a dfs on a first and no cycle was detected but all those nodes were marked as visited so
     *    that we do not run dfs again on any of those first again to save time and iot worked in UDG because
     *    even if we visited the first which was previously visited in a previous DFS, being it UDG we can go back.
     * 2. But DG we can not go back as its single directed hence
     * 3. We need to maintain another visited array for each and every DFS called.
     *    so that we can judge the visited nodes based on current DFS only.
     * 4. Hence, two visited array will be used one globally and one for each DFS & a cycle will be detected in a DFS only if
     *    the same DFS's visited nodes were visited again also we will not explore Globally visited first as they are already done
     * */
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int vertices = adj.size();
        boolean[] global = new boolean[vertices];
        boolean[] inRecursion = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!global[i] && cycleDetected(i, inRecursion, global, adj)) {
                return true;
            }
        }
        return false;
    }

    // Here in a DFS of a vertex if a cycle detected then for that complete cycle we keep inRecursion flag as true
    // and this inRecursion keeps that true till end of all the calculations as we return in mid and "inRecursion[curr] = false;"
    // does not get executed Hence later on this inRecursion will tell us how many nodes were indulged in a cycle
    private boolean cycleDetected(int curr, boolean[] inRecursion, boolean[] global, ArrayList<ArrayList<Integer>> adj) {
        inRecursion[curr] = true;
        global[curr] = true;
        for (Integer next : adj.get(curr)) {
            if (inRecursion[next]) return true;
            if (global[next]) continue;
            if (cycleDetected(next, inRecursion, global, adj)) return true;
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
