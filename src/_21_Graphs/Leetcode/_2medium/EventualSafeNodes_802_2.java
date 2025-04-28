package _21_Graphs.Leetcode._2medium;

import java.util.*;

class EventualSafeNodes_802_2 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int nv = graph.length;
        int[] indegree = new int[nv];

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int u = 0; u < graph.length; u++) {
            for (int j = 0; j < graph[u].length; j++) {
                int v = graph[u][j];
                adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);//making another graph with opposite direction to be able to traverse graph
                indegree[u]++;
            }
        }

        // now we will apply Kahn's algorithm in an indegree format
        // means we will approach graph from ending node to their parents
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        // now all those nodes has been explored who leads to dead end and does not belong to any Cycle, their outdegree === 0
        // to print them we can simply travers outdegree Array
        List<Integer> ans = new ArrayList<>(); // node,part of acyclic component
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) { //those nodes which are
                ans.add(i);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }
}