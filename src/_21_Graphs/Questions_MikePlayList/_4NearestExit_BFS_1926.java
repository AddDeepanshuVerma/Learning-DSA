package _21_Graphs.Questions_MikePlayList;

import java.util.ArrayDeque;

class _4NearestExit_BFS_1926 {
    public static void main(String[] args) {
        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = {1, 2};
        System.out.println(nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];  // initially all are false
        ArrayDeque<int[]> q = new ArrayDeque<>(); // contains {row, col}

        q.addLast(entrance);
        visited[entrance[0]][entrance[1]] = true;

        int walked = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.removeFirst();
                int r = curr[0], c = curr[1];
                if (!(r == entrance[0] && c == entrance[1]) && (r == 0 || r == m - 1 || c == 0 || c == n - 1)) {
                    return walked;// we got into the corner
                }

                for (int[] dir : dirs) {
                    int r_ = r + dir[0], c_ = c + dir[1];
                    if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n || maze[r_][c_] == '+' || visited[r_][c_]) continue;
                    visited[r_][c_] = true;
                    q.addLast(new int[]{r_, c_});
                }
            }
            if (!q.isEmpty()) walked++;
        }
        return -1;
    }
}