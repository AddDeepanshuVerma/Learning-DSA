package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("Applying DSU with max TC <= nlogn :: resultant TC === nlogn + mlogm + n + m + IAF(n)")
class DistanceLimitedPathsExist_1697_3 {
    static class DSU {
        private final int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (i == parent[i]) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent != bParent) {
                parent[bParent] = aParent;
            }
        }

    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DSU dsu = new DSU(n);
        // to make the result in sync, add given indexes of given queries order
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        // now sort both based on given distance & threshold
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        // now apply two pointer
        int j = 0;
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            int threshold = queries[i][2], idx = queries[i][3];

            while (j < edgeList.length && edgeList[j][2] < threshold) {
                dsu.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }

            if (dsu.find(u) == dsu.find(v)) {
                ans[idx] = true;
            }
        }
        return ans;
    }
}