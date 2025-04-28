package _21_Graphs.Leetcode._3hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindCriticalAndPseudoCriticalEdges_1489 {
    // TC : ElogE + (E *(E+E))
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        /*
         * Approach : First we will calculate what is the weight of our MST
         * Then check edges 1 by 1
         * if it is critical        === exclude this edge & if new MST weight >  minimum MST weight (note:must check no multi component)
         * if it is pseudo-critical === include this edge & if new MST weight == minimum MST weight
         * */
        List<Integer> critical = new ArrayList<>();
        List<Integer> pCritical = new ArrayList<>();
        // put the given index values
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            edges[i] = new int[]{u, v, w, i};
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);                      // ElogE
        int minWeight = MST(n, edges);
        //now check if each edge is critical or pseudo-critical
        for (int[] edge : edges) {                                      // E*(E+E)
            int u = edge[0], v = edge[1], w = edge[2], idx = edge[3];
            int tempWeight = MST_exclude(n, edges, idx);
            if (tempWeight > minWeight) {
                critical.add(idx);
                continue;
            }
            tempWeight = MST_include(n, edges, edge);
            if (tempWeight == minWeight) {
                pCritical.add(idx);
            }
        }

        return new ArrayList<>(List.of(critical, pCritical));
    }

    private int MST_exclude(int nv, int[][] edges, int exclude) {
        DSU dsu = new DSU(nv);
        int weight = 0;
        for (int[] edge : edges) {
            if (edge[3] == exclude) continue;
            int u = edge[0], v = edge[1], w = edge[2];
            if (dsu.union(u, v)) {
                weight += w;
            }
        }
        // now we need to check if all components are connected
        // as if we are excluding this edge, and somehow it make multiple components means we can not exclude it
        return dsu.isSingleComponent() ? weight : Integer.MAX_VALUE;
    }

    private int MST_include(int nv, int[][] edges, int[] include) {
        DSU dsu = new DSU(nv);
        int weight = 0;
        dsu.union(include[0], include[1]);
        weight += include[2];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dsu.union(u, v)) {
                weight += w;
            }
        }
        return weight;
    }

    private int MST(int nv, int[][] edges) {
        DSU dsu = new DSU(nv);
        int weight = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dsu.union(u, v)) {
                weight += w;
            }
        }
        return weight;
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
        var obj = new FindCriticalAndPseudoCriticalEdges_1489();
        int n = 6;
        int[][] edges = {{0, 1, 1}, {1, 2, 1}, {0, 2, 1}, {2, 3, 4}, {3, 4, 2}, {3, 5, 2}, {4, 5, 2}};
        List<List<Integer>> ans = obj.findCriticalAndPseudoCriticalEdges(n, edges);
        System.out.println(ans);
    }
}