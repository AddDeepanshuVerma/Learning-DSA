package Interesting;

import java.util.Arrays;

class MinDays_1568_2 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        MinDays_1568_2 obj = new MinDays_1568_2();
        System.out.println(obj.minDays(grid));
    }

    public int minDays(int[][] grid) {
        int islands = checkCurrentIsland(grid);

        // if islands are more than one OR there are no islands, then no need to convert any island
        if (islands != 1) return 0;

        // Convert islands, 1 by 1 to 0 and check if we get updated islands count != 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int count = checkCurrentIsland(grid);
                    if (count != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        // if 0 or 1 is not the answer, then final answer would be 2;
        return 2;
    }

    private int checkCurrentIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    DFS(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void DFS(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        DFS(grid, i + 1, j,visited);
        DFS(grid, i - 1, j,visited);
        DFS(grid, i, j + 1,visited);
        DFS(grid, i, j - 1,visited);
    }
}






