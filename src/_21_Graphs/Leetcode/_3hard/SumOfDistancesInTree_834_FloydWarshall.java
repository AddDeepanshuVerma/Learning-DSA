package _21_Graphs.Leetcode._3hard;

class SumOfDistancesInTree_834_FloydWarshall {
    // TC : V^3 === 64 / 74 testcases passed
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        /*
         * Steps: here as we need to calculate distance of each pair to another pair while the weight of each edge is
         * same which we can assume 1 hence we will be applying Floyd Warshall Algorithm
         * Floyd Warshall : make a 2D array where :
         * 1. First put given edges u->v value as 1, put i == j cases value a 0 & rest value as infinity
         * 2. Now in Floyd Warshall what we do is we make each index of gird {i,j} traverse through each node
         * 3. And we try to get the minimum value we can get & store it
         * */
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) grid[i][j] = 0;
                else grid[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            grid[u][v] = 1;
            grid[v][u] = 1;
        }

        // now we need to relax each grid value through all nodes
        for (int k = 0; k < n; k++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (grid[u][k] != Integer.MAX_VALUE && grid[k][v] != Integer.MAX_VALUE) {
                        grid[u][v] = Math.min(grid[u][v], grid[u][k] + grid[k][v]);
                    }
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