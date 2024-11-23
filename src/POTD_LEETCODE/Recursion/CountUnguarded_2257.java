package POTD_LEETCODE.Recursion;

class CountUnguarded_2257 {
    public static void main(String[] args) {
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};

        CountUnguarded_2257 obj = new CountUnguarded_2257();
        System.out.println(obj.countUnguarded(4, 6, guards, walls));
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        // put walls in the grid
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }

        for (int[] guard : guards) {
            char direction = 'N';
            solve(grid, guard[0], guard[1], direction);
        }

        int count = 0;
        for (char[] chars : grid) {
            for (char character : chars) {
                if (character == 0) count++;
            }
        }
        return count;

    }

    private void solve(char[][] grid, int row, int col, char dir) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 'W') {
            return;
        }

        grid[row][col] = 'V';
        if (dir == 'N') {
            solve(grid, row - 1, col, 'U');
            solve(grid, row + 1, col, 'D');
            solve(grid, row, col - 1, 'L');
            solve(grid, row, col + 1, 'R');
        } else {
            switch (dir) {
                case 'U' -> solve(grid, row - 1, col, 'U');
                case 'D' -> solve(grid, row + 1, col, 'D');
                case 'L' -> solve(grid, row, col - 1, 'L');
                case 'R' -> solve(grid, row, col + 1, 'R');
            }
        }
    }
}