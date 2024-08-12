package Interesting;

import java.util.Arrays;

class MinDays_1568 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        MinDays_1568 obj = new MinDays_1568();
        System.out.println(obj.minDays(grid));
    }

    private int[][] getClone(int[][] grid) {
        return Arrays.stream(grid)
                     .map(int[]::clone)
                     .toArray(int[][]::new);
    }

    public int minDays(int[][] grid) {
        int islands = checkCurrentIsland(getClone(grid));

        // if islands are more than one OR there are no islands, then no need to convert any island
        if (islands != 1) return 0;

        // Convert islands, 1 by 1 to 0 and check if we get updated islands count != 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int count = checkCurrentIsland(getClone(grid));
                    if (count != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        // if 0 or 1 is not the answer, then final answer would be 2;
        return 2;
    }

    private int checkCurrentIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void DFS(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }
}