package _21_Graphs.Leetcode._3hard;

import java.util.*;

class SumOfDistancesInTree_diagram2 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        var obj = new SumOfDistancesInTree_diagram2();
        int[] ans = obj.sumOfDistancesInTree(n, edges);
        System.out.println("ans = " + Arrays.toString(ans));
    }

    private HashMap<Integer, List<Integer>> adj;
    private boolean[] visited;
    private int[] treeSize;
    private int[] ans;
    private int rootAns;
    private int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        ans = new int[N];
        adj = new HashMap<>();
        treeSize = new int[N];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }

        int root = 0, level = 0, currDepth = 0;
        visited = new boolean[N];
        treeSize(root, currDepth); // fills TreeSize and calculates rootAnswer
        ans[0] = rootAns;          // store rootAnswer in our resultant array

        // now we know the answer of one node(0) and TreeSizes of all subTrees hence we can apply reRooting
        reRoot(root, treeSize, -1);

        return ans;
    }

    private int treeSize(int u, int currDepth) {
        visited[u] = true;
        rootAns += currDepth;

        int currSize = 1;
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (!visited[v]) {
                currSize += treeSize(v, currDepth + 1);
            }
        }

        treeSize[u] = currSize;
        return currSize;
    }

    private void reRoot(int u, int[] treeSize, int parent) {
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v != parent) {
                ans[v] = ans[u] - treeSize[v] + (N - treeSize[v]);
                reRoot(v, treeSize, u);
            }
        }
    }
}