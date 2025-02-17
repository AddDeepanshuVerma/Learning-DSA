package POTD_LEETCODE.Array;

class CountServers_1267 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        System.out.println(countServers(grid));
    }

    public static int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int totalServers = 0;
        int aloneServer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalServers++;
                    if (alone(grid, i, j)) {
                        aloneServer++;
                    }
                }
            }
        }
        return totalServers - aloneServer;
    }

    private static boolean alone(int[][] grid, int row, int col) {
        int count = 0;
        int i = 0, j = 0;
        while (i < grid.length) {
            if (grid[i][col] == 1) {
                if (++count > 2) return false;
            }
            i++;
        }

        while (j < grid[0].length) {
            if (grid[row][j] == 1) {
                if (++count > 2) return false;
            }
            j++;
        }
        return true;
    }

    private static boolean alone2(int[][] grid, int row, int col) {
        int count = 0, i = 0, j = 0;
        while (i < grid.length) {
            if (grid[i++][col] == 1 && ++count > 2) return false;
        }

        while (j < grid[0].length) {
            if (grid[row][j++] == 1 && ++count > 2) return false;
        }
        return true;
    }

}