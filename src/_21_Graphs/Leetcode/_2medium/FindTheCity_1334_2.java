package _21_Graphs.Leetcode._2medium;

import java.util.Arrays;

class FindTheCity_1334_2 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] grid = floydWarshall(n, edges);
        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }

        int count = Integer.MAX_VALUE; // need to calculate the minimum count
        int city = -1;

        for (int i = 0; i < grid.length; i++) {
            int temp = 0;
            for (int j = 0; j < grid[i].length; j++) {
//                if (i == j) continue; // can be commented as it is affecting each value equally
                if (grid[i][j] <= distanceThreshold) {
                    temp++;
                }
            }
            if (temp <= count) {
                count = temp;
                city = i;
            }
        }

        return city;
    }

    private static int[][] floydWarshall(int n, int[][] edges) {
        final int INF = (int) 1e9;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], INF);
            grid[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            grid[u][v] = Math.min(grid[u][v], w);
            grid[v][u] = Math.min(grid[v][u], w);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][k] + grid[k][j] < grid[i][j]) {
                        grid[i][j] = grid[i][k] + grid[k][j];
                    }
                }
            }
        }
        return grid;
    }
}
