package _21_Graphs.Leetcode._2medium;

class _5ValidPath_1971_DSU {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // DSU prerequisite
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int uParent = find(u);
            int vParent = find(v);
            if (uParent != vParent) {
                parent[vParent] = uParent;
            }
        }

        return find(source) == find(destination);
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
}