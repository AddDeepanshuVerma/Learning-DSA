package _21_Graphs.Leetcode;

import java.util.ArrayList;
import java.util.List;

class _14MinCostConnectPoints_1584_Kruskal {
    public int minCostConnectPoints(int[][] points) {
        int nv = points.length;
        // need to make a list that contains {u, v, w} and later sort it wrt weight
        List<List<Integer>> adj = new ArrayList<>();

        for (int u = 0; u < nv; u++) {
            for (int v = u + 1; v < nv; v++) { // to make it a directed graph as in DSU undirected has same edge twice.
                int x1 = points[u][0], y1 = points[u][1];
                int x2 = points[v][0], y2 = points[v][1];
                int w = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.add(List.of(u, v, w));
            }
        }
        adj.sort((a, b) -> a.get(2) - b.get(2));

        return kruskalAlgorithm(nv, adj);
    }

    private int kruskalAlgorithm(int nv, List<List<Integer>> adj) {
        int sum = 0;
        parent = new int[nv];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (List<Integer> list : adj) {
            int u = list.get(0), v = list.get(1), w = list.get(2);
            int uParent = find(u);
            int vParent = find(v);
            if (uParent != vParent) {
                sum += w;
                parent[uParent] = vParent; // union code
            }
        }
        return sum;
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int u, int v) {
        int uParent = find(u);
        int vParent = find(v);
        if (uParent != vParent) {
            parent[uParent] = vParent;
        }
    }


}