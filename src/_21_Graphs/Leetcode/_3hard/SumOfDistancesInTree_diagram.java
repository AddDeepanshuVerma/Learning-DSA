package _21_Graphs.Leetcode._3hard;

import java.util.*;

class SumOfDistancesInTree_diagram {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] ans = sumOfDistancesInTree(n, edges);
        System.out.println("ans = " + Arrays.toString(ans));
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        /*
         * KeyPoints :
         * 1. we will make a node as a parent node (lets make it 0 as 0 will always be there)
         * 2. Now we have to first calculate the answer for this root node
         * 3. This problem gets transformed into something called : "A CLASSIC REROOTING DP PROBLEM"
         * 4. REROOTING PROBLEM : here we first calculate the answer for main root and then for rest of its children
         * 5. We calculate their answer via making imaginary root
         *
         * Approach:
         * 1. Let root of the tree == 0
         * 2. Now calculate the answer for this node
         * 3. we also need to calculate the size of all subTrees where root node can be anyone of n nodes
         * 4. Hence, now have two things: answer of root node and an array having size of all node
         * 5. Now we will run a simple DFS where we will calculate the answer for all other nodes based on parent-child relationship
         * 6. Answer of a child Node = ans of parent node - size of curr child tree + remaining node in the tree
         * 7. Which is similar to :
         *           child node = parent node - child node size + (all nodes - child node size)
         * */

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }

        // need to calculate sum of node 0
        int root = 0, level = 0;
        boolean[] visited = new boolean[n];
        int rootAns = rootDFS(root, adj, level, visited);
        System.out.println("rootAns = " + rootAns);

        // need to calculate size of all subTrees
        int[] treeSize = new int[n];
        visited = new boolean[n];
        treeSize(root, adj, visited, treeSize);
        System.out.println("size = " + Arrays.toString(treeSize));

        // now we know the answer of one node(0) and sizes of all subTrees hence we can apply reRooting
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        visited = new boolean[n];

        ans[root] = rootAns;
        reRoot(root, ans, adj, visited, treeSize, n);
        //child node = parent node - child node size + (all nodes - child node size)

        return ans;
    }

    private static int rootDFS(int u, HashMap<Integer, List<Integer>> adj, int level, boolean[] visited) {
        visited[u] = true;
        level++;
        int sum = 0;
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (!visited[v]) {
                sum += level + rootDFS(v, adj, level, visited);
            }
        }

        return sum;
    }

    private static int treeSize(int u, HashMap<Integer, List<Integer>> adj, boolean[] visited, int[] size) {
        visited[u] = true;

        int count = 1; // this node is included hence starts at 1
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (!visited[v]) {
                count += treeSize(v, adj, visited, size); // rest we need to add all sizes of all the children
            }
        }

        size[u] = count;
        return count;
    }

    private static void reRoot(int u, int[] ans, HashMap<Integer, List<Integer>> adj, boolean[] visited, int[] treeSize, int nV) {
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (ans[v] == -1) {
                ans[v] = ans[u] - treeSize[v] + (nV - treeSize[v]);
                reRoot(v, ans, adj, visited, treeSize, nV);
            }
        }
    }
}