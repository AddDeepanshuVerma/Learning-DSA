package _21_Graphs.Leetcode._3hard;

class MinimumCost_3108 {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        final int MASK = (1 << 31) - 1;
        parent = new int[n];
        AND = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            AND[i] = MASK;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], edge[2]);
        }

        int[] ans = new int[query.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = find(query[i][0]) == find(query[i][1]) ? AND[find(query[i][0])] : -1;
        }
        return ans;
    }

    int[] parent;
    int[] AND;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b, int w) {
        int bParent = find(b);
        int aParent = find(a);
        parent[bParent] = aParent;
        AND[aParent] &= AND[bParent] & w;
    }
}