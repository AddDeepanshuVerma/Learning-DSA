package Interesting;

class DSU_LongestCycle_in_DG_2360 {
    public int longestCycle(int[] edges) {
        int nv = edges.length;
        parent = new int[nv];
        for (int i = 0; i < nv; i++)
            parent[i] = i;

        int ans = -1;
        for (int u = 0; u < edges.length; u++) {
            int v = edges[u];
            if (v == -1)
                continue;
            if (find(u) == find(v))
                ans = Math.max(ans, distance(edges, v));
            union(u, v);
        }

        return ans;
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);
        if (aParent != bParent) {
            parent[bParent] = aParent;
        }
    }

    private int distance(int[] edges, int parent) {
        int next = edges[parent];
        int count = 1;
        while (next != parent) {
            count++;
            next = edges[next];
        }
        return count;
    }

}