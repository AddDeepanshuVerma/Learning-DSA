package _21_Graphs.Leetcode._5revision;

import java.util.PriorityQueue;

class MinimumTime_2577 {
    public static int minimumTime(int[][] grid) {
        // given that grid[0][0] is always 0
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1; // edge case

        int m = grid.length, n = grid[0].length;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        boolean[][] seen = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]); // stores node{row, col}
        q.offer(new int[] { 0, 0, 0 });
        seen[0][0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0], c = poll[1], t = poll[2];
            if (r == m - 1 && c == n - 1)
                return t;// reached destination

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n || seen[r_][c_])
                    continue;
                seen[r_][c_] = true;

                int val = grid[r_][c_];
                if (val <= t + 1) { // next cell is less than or equal our (time + 1) then we can simply hop to it
                    q.offer(new int[] { r_, c_, t + 1 });
                } else if (((val - t) & 1) == 1) { // next cell value if greater with odd difference then we hop with next cell value
                    q.offer(new int[] { r_, c_, val });
                } else { // next cell value if greater with even difference then we hop with next (cell value + 1)
                    q.offer(new int[] { r_, c_, val + 1 });
                }
            }
        }
        return -1;
    }

    public static int minimumTime2(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] seen = new boolean[m][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.offer(new int[]{0, 0, 0});
        seen[0][0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0], c = poll[1], t = poll[2];
            if (r == m - 1 && c == n - 1) return t;// reached destination

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n || seen[r_][c_]) continue;
                seen[r_][c_] = true;

                int val = grid[r_][c_];
                int t_ = 0;
                if (val <= t + 1) {
                    t_ = t + 1;
                } else if (((val - t) & 1) == 1) {
                    t_ = val;
                } else {
                    t_ = val + 1;
                }
                q.offer(new int[]{r_, c_, t_});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}};
        int time = minimumTime(grid);
        System.out.println("time = " + time);
    }
}