package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.*;

class _21_Euler_Path_print {

    private static List<Integer> path;
    private static HashMap<Integer, ArrayDeque<Integer>> adj;

    public static void main(String[] args) {
        int[][] pairs = {{11, 9}, {9, 4}, {4, 5}, {5, 1}};
        printEuler(pairs);
        System.out.println(path);
    }

    //Here we are assuming that Euler Path exists in this DG, and we just need to print it
    public static void printEuler(int[][] pairs) {
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
        System.out.println(path);
    }

    /*Here as we will be applying postOrder in DFS approach and it will work.
        Steps:
        1. Add my children first then at the end add me
        2. Hence, if there would not be children then simply Add me
        3. And When a child is processed remove it so that later we do not use this edge again and gets looped inside

        So lets say we have 2 paths from 1 -> 2, 3

        1. Suppose in a case we choose 3 first and apply that "add my children First" then answer would be 1 -> 3 -> remove 3 as adj of 1-> no more child -> add 3 -> now from 1 we will explore other children if exists? -> yes 2 exists -> remove 2 but do not add now and check 2 has child? -> yes -> go to child 1 -> remove 1 as adj from 2, do not add now and check 1 has child->  no child -> then add 1 -> now go back to its parent 2 -> now 2 has no more child hence add 2 -> now go to 2's parent -> check anymore child of 1 remaining-> no child remaining -> add 1 -> check its parent -> no parent -> DFS ended
        Hence we got 3 -> 1 -> 2- > 1.

        2. Similarly, we can do the same for " we choose as first child of 1" ==> 1 -> 2 -> 1 -> 3 -> none -> add 3 -> none -> add 1-> none -> add 2 -> none -> add 1
        Hence = 3 -> 1 -> 2 -> 1.

        It's similar to topological, done using DFS approach instead of BFS,.
        It took 1h of mine, hope does not take yours.*/
    private static void dfs(int node) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            int nextNode = adj.get(node).remove();  // Remove the edge after visiting
            dfs(nextNode);  // Recursive DFS call
        }
        path.add(node);  // Add node to Euler path after all edges are visited
    }
}