package _21_Graphs.Leetcode;

import java.util.*;

class _1FindCircleNum_547_2 {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private static void dfs(int u, int[][] grid, boolean[] visited) {
        if (visited[u]) return;
        visited[u] = true;

        for (int v = 0; v < grid[u].length; v++) {
            if (!visited[v] && grid[u][v] == 1) {
                dfs(v, grid, visited);
            }
        }
    }
}