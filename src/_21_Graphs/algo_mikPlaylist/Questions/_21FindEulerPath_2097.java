package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.*;

class _21FindEulerPath_2097 {

    private static List<Integer> path;
    private static HashMap<Integer, ArrayDeque<Integer>> adj;

    public static void main(String[] args) {
        int[][] pairs = {{11, 9}, {9, 4}, {4, 5}, {5, 1}};
        validArrangement(pairs);
    }

    public static int[][] validArrangement(int[][] pairs) {
        adj = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, Integer> outdegree = new HashMap<>();

        for (int[] pair : pairs) {
            int u = pair[0], v = pair[1];
            indegree.merge(v, 1, Integer::sum);
            outdegree.merge(u, 1, Integer::sum);
            adj.computeIfAbsent(u, val -> new ArrayDeque<>()).offer(v);
        }

        int startNode = -1;
        int endNode = -1;

        for (int node : adj.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;
            }
            if (indegree.getOrDefault(node, 0) - outdegree.getOrDefault(node, 0) == 1) {
                endNode = node;
            }
        }
        // means it was a circle or Euler circle, hence any node can be starting node
        if (startNode == -1) startNode = pairs[0][0];

        // now simply do DFS traversal from starting node
        // in this DFS traversal we are more likely going for topological sort's DFS approach means: add my children first then add me
        path = new ArrayList<>();
        dfs(startNode);
        Collections.reverse(path);

        int[][] res = new int[pairs.length][];
        for (int i = 0; i < res.length; i++) {
            res[i] = new int[]{path.get(i), path.get(i + 1)};
        }

        return res;
    }

    private static void dfs(int node) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            int nextNode = adj.get(node).remove();  // Remove the edge after visiting
            dfs(nextNode);  // Recursive DFS call
        }
        path.add(node);  // Add node to Euler path after all edges are visited
    }
}