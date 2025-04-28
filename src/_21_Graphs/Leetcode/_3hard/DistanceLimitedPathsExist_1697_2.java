package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

@Description("Applied Floyd Warshall for each node in graph : n^3 :: TLE")
class DistanceLimitedPathsExist_1697_2 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        final int MAX = (int) (1e9 + 1);
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) distance[i][j] = 0;
                distance[i][j] = MAX;
            }
        }

        for (int[] edge : edgeList) {
            int u = edge[0], v = edge[1], w = edge[2];
            distance[u][v] = Math.min(distance[u][v], w);
            distance[v][u] = Math.min(distance[v][u], w);
        }

        // here we will go i -> j from each node k
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Math.max(distance[i][k], distance[k][j]) < distance[i][j]) {
                        distance[i][j] = Math.max(distance[i][k], distance[k][j]);
                    }
                }
            }
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1], max = queries[i][2];
            ans[i] = distance[u][v] < max;
        }
        return ans;
    }

}