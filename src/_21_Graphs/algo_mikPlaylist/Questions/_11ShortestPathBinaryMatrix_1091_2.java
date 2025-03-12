package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.ArrayDeque;
import java.util.Arrays;

class _11ShortestPathBinaryMatrix_1091_2 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        /*
         * As we are travelling only on same weighted graphs
         * hence who ever is entered later will have more and should be put at the end.
         * Hence Instead of PriorityQueue we can use simple Queue.
         * */
        int r = grid.length, c = grid[0].length;
        if (grid[0][0] == 1 || grid[r - 1][c - 1] == -1) return -1; // base check

        int[][] paths = new int[r][c];
        for (int[] path : paths) Arrays.fill(path, Integer.MAX_VALUE);

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}; // 8 directional

        ArrayDeque<int[]> pq = new ArrayDeque<>(); // {r, c, travelled}
        pq.offer(new int[]{0, 0, 1});
        paths[0][0] = 1;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int ur = poll[0], uc = poll[1], path = poll[2];

            for (int[] dir : dirs) {
                int vr = ur + dir[0];
                int vc = uc + dir[1];
                if (vr < 0 || vr >= r || vc < 0 || vc >= c || grid[vr][vc] == 1) continue; // all invalid cases
                if (path + 1 < paths[vr][vc]) {
                    paths[vr][vc] = path + 1;
                    pq.offer(new int[]{vr, vc, path + 1});
                }
            }
        }

        return paths[r - 1][c - 1] == Integer.MAX_VALUE ? -1 : paths[r - 1][c - 1];
    }
}