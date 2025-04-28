package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.List;

class EventualSafeNodes_802 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int nv = graph.length;
        boolean[] global = new boolean[nv];
        boolean[] inRecursion = new boolean[nv];

        for (int i = 0; i < nv; i++) {
            if (!global[i]) {
                cycleDetected(i, inRecursion, global, graph);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < global.length; i++) {
            if (!inRecursion[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    // Here in a DFS of a vertex if a cycle detected then for that complete cycle we keep inRecursion flag as true
    // and this inRecursion keeps that true till end of all the calculations as we return in mid and "inRecursion[curr] = false;"
    // does not get executed Hence later on this inRecursion will tell us how many nodes were indulged in a cycle
    private static boolean cycleDetected(int curr, boolean[] inRecursion, boolean[] global, int[][] adj) {
        inRecursion[curr] = true;
        global[curr] = true;
        for (int next : adj[curr]) {
            if (inRecursion[next]) return true;
            if (global[next]) continue;
            if (cycleDetected(next, inRecursion, global, adj)) return true;
        }
        inRecursion[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1}, {2}, {0}, {1}};
        System.out.println(eventualSafeNodes(graph));
    }
}