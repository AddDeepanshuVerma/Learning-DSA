package _21_Graphs.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _15MinimumSpanningTree_Kruskal {
    static int kruskal_Algorithm(int V, int E, List<List<int[]>> adj) {
        parent = new int[V];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        List<List<Integer>> edges = new ArrayList<>();
        for (int u = 0; u < adj.size(); u++) {
            for (int[] pair : adj.get(u)) {
                edges.add(List.of(u, pair[0], pair[1]));
            }
        }
        edges.sort((a, b) -> a.get(2) - b.get(2));

        return kruskalAlgo(edges);
    }

    private static int kruskalAlgo(List<List<Integer>> edges) {
        int sum = 0;
        for (List<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);

            int uParent = find(u);
            int vParent = find(v);
            if (uParent != vParent) {
                sum += w;
                union(u, v);
            }
        }
        return sum;
    }

    static int[] parent;

    static int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    static void union(int u, int v) {
        int uParent = find(u);
        int vParent = find(v);
        if (uParent != vParent) {
            parent[uParent] = vParent;
        }
    }

}
