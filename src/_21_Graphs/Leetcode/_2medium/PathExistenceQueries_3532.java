package _21_Graphs.Leetcode._2medium;

class PathExistenceQueries_3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                int uParent = find(i);
                int vParent = find(i + 1);
                if (uParent != vParent) {
                    union(i, i + 1);
                }
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (find(u) == find(v)) {
                ans[i] = true;
            }
        }
        return ans;
    }

    int[] parent;
    int[] size;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);

        if (aParent == bParent) return;
        if (size[aParent] == size[bParent]) {
            size[aParent] += size[bParent];
            parent[bParent] = aParent;
        } else if (size[aParent] > size[bParent]) {
            size[aParent] += size[bParent];
            parent[bParent] = aParent;
        } else {
            size[bParent] += size[aParent];
            parent[aParent] = bParent;
        }
    }

}