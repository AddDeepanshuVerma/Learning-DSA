package _21_Graphs.Leetcode._3hard;

class SumOfDistancesInTree_834_FloydWarshall_cmpt {
    // TC : V^3 === 64 / 74 testcases passed
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        final int INF = 100000;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) grid[i][j] = 0;
                else grid[i][j] = INF;
            }
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            grid[u][v] = 1;
            grid[v][u] = 1;
        }

        // now we need to relax each grid getValue through all nodes
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
            ans[i] = sum;
        }
        return ans;
    }
}