package _21_Graphs.Leetcode._5revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CheckIfPrerequisite_1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //Let's apply FloydWarshall Algorithm
        int nv = numCourses;
        int[][] grid = floydWarshall(prerequisites, nv);

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0], v = query[1];
            if (grid[u][v] != Integer.MAX_VALUE) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    private static int[][] floydWarshall(int[][] prerequisites, int nv) {
        int[][] grid = new int[nv][nv];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
            grid[i][i] = 0;
        }

        for (int[] edge : prerequisites) {
            int u = edge[0], v = edge[1];
            grid[u][v] = 1;
        }

        for (int k = 0; k < nv; k++) {
            for (int i = 0; i < nv; i++) {
                if (grid[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < nv; j++) {
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