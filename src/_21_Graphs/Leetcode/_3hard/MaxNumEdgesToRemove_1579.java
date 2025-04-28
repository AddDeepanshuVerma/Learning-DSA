package _21_Graphs.Leetcode._3hard;

class MaxNumEdgesToRemove_1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int totalEdges = edges.length;
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        // First make bonds of all those edges which both alice & bob can use
        int usedEdges = 0;
        for (int[] edge : edges) {
            int u = edge[1], v = edge[2], type = edge[0];
            if (type == 3) { // both alice and bob can travel
                boolean thisEdgeUsed = false;
                if (alice.union(u, v)) thisEdgeUsed = true;
                if (bob.union(u, v)) thisEdgeUsed = true;

                if (thisEdgeUsed) usedEdges++;
            }
        }

        for (int[] edge : edges) {
            int u = edge[1], v = edge[2], type = edge[0];
            if (type == 3) continue;
            if (type == 1 && alice.union(u, v)) usedEdges++;
            if (type == 2 && bob.union(u, v)) usedEdges++;
        }

        // now if both alice and bob has travelled all components in graph then remaining edges would be the ans orElse -1
        if (alice.isSingleComponent() && bob.isSingleComponent()) {
            return totalEdges - usedEdges;
        }
        return -1;
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

        boolean union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent == bParent) {
                return false;// no union was done
            }
            parent[bParent] = aParent;
            components--;
            return true;
        }

        boolean isSingleComponent() {
            return components == 1;
        }
    }
}