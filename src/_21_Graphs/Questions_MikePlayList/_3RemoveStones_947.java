package _21_Graphs.Questions_MikePlayList;

import java.io.FileInputStream;
import java.util.*;

class _3RemoveStones_947 {
    public int removeStones(int[][] stones) {
        /*
         * Here we need to calculate no of islands in the 2D plane
         * We can use DSU to get the number of components remaining after connecting all those have edges
         * Steps: 1. Get those nodes which are connected to each other in an edge[][] array
         * 2. Union all those which belong to same part
         * 3. Rest find how many components remained
         *  */

        int nV = stones.length;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int u = 0; u < nV; u++) {
            for (int v = u + 1; v < nV; v++) {
                int[] v1 = stones[u], v2 = stones[v];
                if (v1[0] == v2[0] || v1[1] == v2[1]) { // means they are connected hence form an edge
                    graph.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
                    graph.computeIfAbsent(v, list -> new ArrayList<>()).add(u); // we don't need this as this is UnDirected Graph
                }
            }
        }

        // we got the graph now simply apply DSU
        parent = new int[nV]; // here 0th index representing 0th node from given stones list i === {Xi, Yi}
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int totalComponents = nV;
        for (var item : graph.entrySet()) {
            int u = item.getKey();
            List<Integer> neighbours = item.getValue();

            for (int v : neighbours) {
                int uParent = find(u);
                int vParent = find(v);
                if (uParent != vParent) {
                    totalComponents--;
                    parent[uParent] = vParent;
                }
            }
        }

        return nV - totalComponents;
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
}