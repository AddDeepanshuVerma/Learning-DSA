package _21_Graphs.Leetcode._3hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindCriticalAndPseudoCriticalEdges_1489_compact {
    // TC : ElogE + (E*E)
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> critical = new ArrayList<>(), pCritical = new ArrayList<>();
        // put the given index values
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);                                  // ElogE
        int mstWeight = MST(n, edges, -1, -1);
        //now check if each edge is critical or pseudo-critical
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2], idx = edges[i][3];// E*E
            if (MST(n, edges, i, -1) > mstWeight) {
                critical.add(idx);
            } else if (MST(n, edges, -1, i) == mstWeight) {
                pCritical.add(idx);
            }
        }

        return new ArrayList<>(List.of(critical, pCritical));
    }

    private int MST(int nv, int[][] edges, int exclude, int include) {
        DSU dsu = new DSU(nv);
        int weight = 0;
        if (include != -1) {
            dsu.union(edges[include][0], edges[include][1]);
            weight += edges[include][2];
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == exclude) continue;
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if (dsu.union(u, v)) {
                weight += w;
            }
        }
        return dsu.isSingleComponent() ? weight : Integer.MAX_VALUE;
    }

    static class DSU {
        int[] parent;
        int components;

        public DSU(int nv) {
            components = nv;
            parent = new int[nv];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        int find(int i) {
            if (i == parent[i]) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        boolean union(int a, int b) {
            int bParent = find(b);
            int aParent = find(a);
            if (aParent == bParent) return false;
            parent[bParent] = aParent;
            components--;
            return true;
        }

        boolean isSingleComponent() {
            return components == 1;
        }
    }

    public static void main(String[] args) {
        var obj = new FindCriticalAndPseudoCriticalEdges_1489_compact();
        int n = 6;
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {0, 2, 1}, {2, 3, 4}, {3, 4, 2}, {3, 5, 2}, {4, 5, 2}};
        List<List<Integer>> ans = obj.findCriticalAndPseudoCriticalEdges(n, edges);
        System.out.println(ans);
    }
}