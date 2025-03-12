package _21_Graphs.Leetcode._2medium;

class _5ValidPath_1971_DSU_COMPACT {
    int[] parent;

    int find(int i) {
        return i == parent[i] ? i : (parent[i] = find(parent[i]));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) parent[find(edge[1])] = find(edge[0]);

        return find(source) == find(destination);
    }
}