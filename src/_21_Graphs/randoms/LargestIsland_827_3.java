package _21_Graphs.randoms;

import jdk.jfr.Description;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class LargestIsland_827_3 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 0}};
        var obj = new LargestIsland_827_3();
        System.out.println(obj.largestIsland(grid));
    }

    @Description("Optimized one")
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        HashMap<Integer, Integer> idSum = new HashMap<>(); // island id's total sum
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int islandID = 2;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    idSum.put(islandID, dfs(i, j, m, n, islandID, grid, dirs));
                    islandID++;
                }
            }
        }
        if (idSum.isEmpty()) return 1;
        if (idSum.size() == 1) return idSum.get(--islandID) == m * n ? m * n : idSum.get(islandID) + 1;

        int maxIslandSize = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // need to find all the Land id's this water is connected to
                    Set<Integer> ngbrs = new HashSet<>();
                    for (int[] dir : dirs) {
                        int newI = i + dir[0], newJ = j + dir[1];
                        if (newI < 0 || newI >= m || newJ < 0 || newJ >= n || grid[newI][newJ] == 0) continue;
                        ngbrs.add(grid[newI][newJ]);
                    }
                    if (ngbrs.isEmpty()) continue;
                    int totalIsland = 0;
                    for (int ngbr : ngbrs) {
                        totalIsland += idSum.get(ngbr);
                    }
                    maxIslandSize = Math.max(maxIslandSize, totalIsland + 1);
                }
            }
        }
        return maxIslandSize;
    }

    private int dfs(int r, int c, int m, int n, int islandID, int[][] grid, int[][] dirs) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = islandID;
        int sum = 1;
        for (int[] dir : dirs) {
            int r_ = r + dir[0], c_ = c + dir[1];
            sum += dfs(r_, c_, m, n, islandID, grid, dirs);
        }
        return sum;
    }
}