package _21_Graphs.Leetcode._3hard;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("Floyd Warshall does not work in this & operator case")
class MinimumCost_3108_FloydW {
    private final static int INF = 1000_000;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // FloydWarshall preRequisites
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) grid[i][j] = 0;
                else grid[i][j] = INF;
            }
        }
        // put all the edges value given by their weight
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            grid[u][v] = w;
            grid[v][u] = w;
        }
        // As per Floyd Warshall algo, we will keep on finding the path for each index going through each vertex & store the minimum one
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][k] == INF) continue; // the u itself is not reachable till this iteration
                    if (i == k || j == k || i == j) continue;
                    int and = grid[i][k] & grid[k][j];
                    if (and < grid[i][j]) {
                        grid[i][j] = and;
                    }
                }
            }
        }
        // which are still unReachable means has value=== INF, we can mark them as -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == INF) {
                    grid[i][j] = -1;
                }
            }
        }
        for (int[] arr : grid) {
            System.out.println(Arrays.toString(arr));
        }

        // Floyd Warshall completed now lets answer our queries
        int[] ans = new int[query.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = grid[query[i][0]][query[i][1]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        int[][] query = {{0, 3}, {3, 4}};

        var obj = new MinimumCost_3108_FloydW();
        int[] ans = obj.minimumCost(n, edges, query);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}