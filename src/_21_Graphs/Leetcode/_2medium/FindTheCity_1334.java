package _21_Graphs.Leetcode._2medium;

import java.util.Arrays;

class FindTheCity_1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] grid = floydWarshall(n, edges);
        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }

        int reachableCount = Integer.MAX_VALUE;
        int city = -1;

        for (int i = 0; i < grid.length; i++) {
            int currCity = i;
            int currCount = 0;
            for (int j = 0; j < grid[i].length; j++) {
//                if (i == j) continue;
                if (grid[i][j] <= distanceThreshold) {
                    currCount++;
                }
            }
            if (currCount <= reachableCount) {
                reachableCount = currCount;
                city = currCity;
            }
        }

        return city;
    }

    private static int[][] floydWarshall(int n, int[][] edges) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
            grid[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            grid[u][v] = Math.min(grid[u][v], w);
            grid[v][u] = Math.min(grid[v][u], w);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < n; j++) {
                    if (grid[k][j] == Integer.MAX_VALUE) continue;
                    if (grid[i][k] + grid[k][j] < grid[i][j]) {
                        grid[i][j] = grid[i][k] + grid[k][j];
                    }
                }
            }
        }
        return grid;
    }
}
