package _21_Graphs.Leetcode._3hard;

import java.util.*;

//https://leetcode.com/problems/number-of-good-paths/solutions/3053512/java-solution-with-comments-and-explanation/
class NumberOfGoodPaths_2421_again {

    int[] parent, size; // parent array to keep track of parent of each node and size array to keep track of number of nodes in each set
    int res; // variable to store the number of good paths

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        // sort edges based on the maximum getValue of the nodes in the edge
        Arrays.sort(edges, (a, b) -> Math.max(vals[a[0]], vals[a[1]]) - Math.max(vals[b[0]], vals[b[1]]));
        int n = vals.length;
        res = n; // initialize number of good paths to be equal to number of nodes
        parent = new int[n];
        size = new int[n];

        Arrays.fill(size, 1); // initialize size of nodes in each set to be 1

        for (int i = 0; i < n; i++) parent[i] = i; // initialize parent of each node to be itself
        for (int[] edge : edges) {
            union(edge[0], edge[1], vals);
        }
        return res;
    }

    private void union(int a, int b, int[] vals) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) return; // if a and b are already in the same set, return
        if (vals[aParent] == vals[bParent]) {
            // if the values of the parents of a and b are equal, update number of good paths
            res += size[aParent] * size[bParent];
            size[aParent] += size[bParent];
            parent[bParent] = aParent;
        } else if (vals[aParent] > vals[bParent]) {
            parent[bParent] = aParent;
        } else {
            parent[aParent] = bParent;
        }
    }

    private int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public static void main(String[] args) {
        int[] vals = {1, 3, 2, 1, 3};
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        var obj = new NumberOfGoodPaths_2421_again();
        System.out.println(obj.numberOfGoodPaths(vals, edges));
    }
}