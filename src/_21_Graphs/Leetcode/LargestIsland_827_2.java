package _21_Graphs.Leetcode;

import jdk.jfr.Description;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class LargestIsland_827_2 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        var obj = new LargestIsland_827_2();
        System.out.println(obj.largestIsland(grid));
    }

    @Description("Test cases passed, but can be optimized")
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // checking if grid is full of land only
        int waterCount = 0;
        for (int[] ints : grid)
            for (int val : ints)
                if (val == 0) waterCount++;
        if (waterCount == 0) return m * n;
        if (waterCount == m * n) return 1;

        boolean[][] visited;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int islandID = 2;
        HashMap<Integer, Integer> idSum = new HashMap<>(); // island id's total sum

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited = new boolean[m][n];
                    int sum = dfs(i, j, m, n, islandID, grid, visited, dirs);
                    idSum.put(islandID, sum);
                    islandID++;
                }
            }
        }

        int max = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // need to find all the Land id's this water is connected to
                    Set<Integer> ids = new HashSet<>();
                    for (int[] dir : dirs) {
                        int newI = i + dir[0], newJ = j + dir[1];
                        if (newI < 0 || newI >= m || newJ < 0 || newJ >= n || grid[newI][newJ] == 0) continue;
                        ids.add(grid[newI][newJ]);
                    }
                    if (ids.isEmpty()) continue;
                    int sum = 0;
                    for (Integer id : ids) {
                        sum += idSum.get(id);
                    }
                    max = Math.max(max, sum + 1);
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int m, int n, int islandID, int[][] grid, boolean[][] visited, int[][] dirs) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;
        grid[r][c] = islandID;
        int sum = 1;
        for (int[] dir : dirs) {
            int r_ = r + dir[0], c_ = c + dir[1];
            sum += dfs(r_, c_, m, n, islandID, grid, visited, dirs);
        }
        return sum;
    }
}