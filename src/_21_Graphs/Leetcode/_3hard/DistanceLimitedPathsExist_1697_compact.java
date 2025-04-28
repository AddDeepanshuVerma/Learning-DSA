package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("Applying DSU with max TC <= nlogn :: resultant TC === nlogn + mlogm + n + m + IAF(n)")
class DistanceLimitedPathsExist_1697_compact {
    int[] parent;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(queries, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int j = 0;
        boolean[] ans = new boolean[queries.length];
        for (int[] query : queries) {
            int u = query[0], v = query[1];
            int threshold = query[2], idx = query[3];
            while (j < edgeList.length && edgeList[j][2] < threshold) {
                union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            if (find(u) == find(v)) {
                ans[idx] = true;
            }
        }
        return ans;
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