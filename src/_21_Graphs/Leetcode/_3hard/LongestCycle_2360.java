package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.*;

@Description("Given that each node has at most one outgoing edge : is important")
class LongestCycle_2360 {

    private HashMap<Integer, List<Integer>> adj;

    @Description(" Topological sort + DSU")
    public int longestCycle(int[] edges) {
        /*
         * Approach :
         * 1. First we need to check if cycle even exists or not
         * 2. As it is a directed graph we are using TOPOLOGICAL sort for cycle detection
         * 3. Now if we are sure that cycle exists we can use multiple ways to detect the length of remaining cycles & return the maximum one
         *    As no two cycles would be connected as given that : EACH NODE HAS AT MOST ONE OUTGOING EDGE
         * 4. Detect cycle length :
         *       A. Apply DSU on all remaining nodes considering them bidirectional and go through that parent array to get common number of components
         *       B. As all remaining node would have 1 indegree and 1 outdegree then we can run simple forLoop on all nonZero indegree node & count traversal
         * */

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

        if (count == nv) {
            // means there was no cycle as we got the topological array count ==  total Nodes
            return -1;
        }

        // now cycle is there and there might be multiple cycles & we need to return the length of longest cycle
        // There are multiple ways to detect it:

        // lets apply DSU
        // DSU preRequisite :
        parent = new int[nv];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int maxLen = 1;
        // let's treat remaining nodes as of biDirectional
        for (int u = 0; u < edges.length; u++) {
            int v = edges[u];
            if (indegree[u] == 0) continue; // as this is not the part of any cycle, remaining would be
//            int uParent = find(u);
//            int vParent = find(v);
//            if (uParent == vParent){} // it means cycle detected, but need length hence skip this part
            union(u, v);
        }
        // now lets count how many frequencies are same which has same parent
        int[] freqes = new int[nv];
        for (int i = 0; i < parent.length; i++) {
            int parent = find(i);
            freqes[parent]++;
        }
        // now here whichever index has the maximum freq: this many components has same parent means: it represents the size
        for (int freq : freqes) {
            maxLen = Math.max(maxLen, freq);
        }

        return maxLen;
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

    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);
        if (aParent != bParent) {
            parent[bParent] = aParent;
        }
    }

}