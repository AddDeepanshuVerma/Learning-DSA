package _21_Graphs.Leetcode._3hard;

class MaxNumEdgesToRemove_1579_compact {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU a = new DSU(n), b = new DSU(n);

        int usedEdges = 0;
        for (int[] edge : edges) {
            int u = edge[1], v = edge[2], type = edge[0];
            if (type == 3) { // both alice and bob can travel
                usedEdges += a.union(u, v) | b.union(u, v);
            }
        }

        for (int[] edge : edges) {
            int u = edge[1], v = edge[2], type = edge[0];
            if (type == 1) usedEdges += a.union(u, v);
            if (type == 2) usedEdges += b.union(u, v);
        }

        return a.oneComp() && b.oneComp() ? edges.length - usedEdges : -1;
    }

    private static class DSU {
        int[] parent;
        int components;

        public DSU(int n) {
            components = n;
            parent = new int[n + 1];
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

        int union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent == bParent) {
                return 0;// no union was done
            }
            parent[bParent] = aParent;
            components--;
            return 1;
        }

        boolean oneComp() {
            return components == 1;
        }
    }
}