package _21_Graphs.Leetcode._5revision;

class FindRedundantConnection_684_compact {
    public int[] findRedundantConnection(int[][] edges) {
        int nv = edges.length;
        parent = new int[nv + 1];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        int[] ans = {-1, -1};
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int uParent = find(u), vParent = find(v);
            if (uParent == vParent) {
                ans = new int[]{u, v};
            } else {
                parent[uParent] = vParent;
            }
        }
        return ans;
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }
}