package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.*;

class LongestCycle_2360_2 {

    private HashMap<Integer, List<Integer>> adj;

    @Description(" Topological sort + forLoop")
    public int longestCycle(int[] edges) {
        int nv = edges.length;
        adj = new HashMap<>();
        int[] indegree = new int[nv];

        for (int u = 0; u < edges.length; u++) {
            int v = edges[u];
            if (v == -1) continue; // u is pointing to noOne
            indegree[v]++;
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
        }

        // run topological sort
        int count = topologicalSort(indegree);
        if (count == nv) return -1;// means there was no cycle as we got the topological array count ==  total Nodes
        int maxLen = 1;

        // simple loop to detect cycle
        // Approach : as we know all remaining nodes either in same cycle in multiple cycle but one thing is sure that
        // each node has 1 outdegree and 1 inDegree Hence we will start from any node and count the loop until we reach the same node again
        for (int node = 0; node < indegree.length; node++) {
            if (indegree[node] == 0) continue; // as this is not the part of cycle
            int len = findLength(node, edges, indegree);
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    private int findLength(int parent, int[] edges, int[] indegree) {
        int next = edges[parent];
        int count = 1;
        while (next != parent) {
            count++;
            indegree[next]--;
            next = edges[next];
        }
        indegree[parent]--;
        return count;
    }

    private int topologicalSort(int[] indegree) {
        int count = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            count++;

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] edges = {3, 3, 4, 2, 3};
        var obj = new LongestCycle_2360_2();
        System.out.println(obj.longestCycle(edges));
    }

}