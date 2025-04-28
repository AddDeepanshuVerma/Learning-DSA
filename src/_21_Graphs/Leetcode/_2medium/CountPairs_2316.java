package _21_Graphs.Leetcode._2medium;

class CountPairs_2316 {
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int uParent = find(u), vParent = find(v);
            if (uParent != vParent) {
                parent[vParent] = uParent; // union them
            }
        }

        // find how many has same Parents
        int[] freq = new int[n];
        for (int i = 0; i < parent.length; i++) {
            freq[parent[find(i)]]++; // to make sure the parent value of each node is updated
        }

        long nv = n;
        long ans = (nv * (nv - 1)) >>> 1; // all pairs that can be build
        for (long val : freq) {
            ans -= (val * (val - 1)) >>> 1;
        }
        return ans;
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        parent[bParent] = aParent;
    }

}