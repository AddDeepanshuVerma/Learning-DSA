package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class _2CanFinish_207_DFS {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
         * Approach:
         * Hence our approach would be to find if cycle is there or not
         * If cycle is there, task is impossible else possible
         * Algo:
         * As we know It's a Directed Graph, so we'll think about topological
         * Hence if we could get the complete topological sorted array, cycle is there else not
         * */
        //prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] arr : prerequisites) {
            adj.computeIfAbsent(arr[1], list -> new ArrayList<>()).add(arr[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && cycleDetected(i, adj, visited, inRecursion)) {
                return false;
            }
        }
        return true;
    }

    private static boolean cycleDetected(int u, HashMap<Integer, List<Integer>> adj, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (inRecursion[v]) return true; // first check if the same occurred again in same path
            if (visited[v]) continue; // if not then check if calculations has been done earlier for the same then don't do it again
            if (cycleDetected(v, adj, visited, inRecursion)) { // finally it has to be explored
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }

}