package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.Arrays;
import java.util.PriorityQueue;

class _11ShortestPathBinaryMatrix_1091 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        /*
         * KeyPoints: While applying Dijkstra Algorithm, we need to make sure below points
         * we can go in 8 directions, if it is a valid index to hop to
         * check that grid value is 0 only, and hop on to it while increasing the travelled path in pq
         * here pq will be sorted in order of minimum path travelled and a travelled path array would be there
         * Which we will update if we get better answer and simultaneously put in the queue also.
         * */

        if (grid[0][0] == 1) return -1; // base check
        int r = grid.length, c = grid[0].length;
        int[][] paths = new int[r][c];
        for (int[] path : paths) Arrays.fill(path, Integer.MAX_VALUE);

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}}; // 8 directional

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // {r, c, travelled}
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