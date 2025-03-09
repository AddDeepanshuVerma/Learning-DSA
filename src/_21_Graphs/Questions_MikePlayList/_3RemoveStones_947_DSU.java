package _21_Graphs.Questions_MikePlayList;

import java.util.ArrayList;
import java.util.List;

class _3RemoveStones_947_DSU {
    public static int removeStones(int[][] stones) {
        int nV = stones.length;
        List<int[]> edges = new ArrayList<>();

        for (int u = 0; u < nV; u++) {
            for (int v = u + 1; v < nV; v++) { // we can also start v = 0, but its extra work when applying DSU
                int[] v1 = stones[u], v2 = stones[v];
                if (v1[0] == v2[0] || v1[1] == v2[1]) { // means they are connected hence form an edge
                    edges.add(new int[]{u, v});
                }
            }
        }

        // we got the graph now simply apply DSU
        parent = new int[nV];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int removedNodes = 0;
        for (int[] edge : edges) {
            int uParent = find(edge[0]);
            int vParent = find(edge[1]);
            if (uParent != vParent) {
                removedNodes++;
                parent[uParent] = vParent;
            }
        }

        return removedNodes;
    }

    static int[] parent;

    static int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
}