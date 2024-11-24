package POTD_LEETCODE.Level_2;

class CountSubIslands_1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // go through every element of grid2 and if any element is land
        // convert it's all connected land to water
        int ans = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    // convert all its connected nodes to water and return true only if all those lands were
                    // land in grid1 as well, even if any single one of those connected lands of grid2's mirror in grid1
                    // was water return false
                    ans += DFS(grid1, grid2, i, j) ? 1 : 0;
                }
            }
        }
        return ans;
    }

    private boolean DFS(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[i].length || grid2[i][j] == 0) {
            return true;
        }
        // mark this land as visited (or not land anymore)
        grid2[i][j] = 0;

        // if mirror of grid2's land if land in mirror 1 then one node of this land is fine
        // will be repeating the same for all nodes of this land
        boolean result = grid1[i][j] == 1;

        result = result & DFS(grid1, grid2, i + 1, j);
        result = result & DFS(grid1, grid2, i - 1, j);
        result = result & DFS(grid1, grid2, i, j + 1);
        result = result & DFS(grid1, grid2, i, j - 1);
        return result;
    }
}