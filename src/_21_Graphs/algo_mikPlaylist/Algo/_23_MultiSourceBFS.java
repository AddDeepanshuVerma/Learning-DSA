package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.ArrayDeque;

public class _23_MultiSourceBFS {
    /*
     * Definition : It is nothing but Breadth First Search but starting with multiple source
     *
     * When to use :
     * It starts simultaneously from multiple sources/nodes.
     * Useful when you want to spread out from multiple source at once.
     * When you need to compute the shortest distance from multiple starting points to other points in graph
     *
     * NOTE: Multi source BFS ensures that all nodes are reached with minimal time from nearest source.
     *
     * How to do :
     * As in BFS we initially start BFS from one point here we start BFS from multiple points hence initially with a given
     * condition satisfied, we put them in the que and run the BFS as per queue size again and again with visited structure to
     * not visit the same visited node.
     * */

    public static int[][] MultiSourceBFS(int[][] grid) {
        // Let problem says all the index having 0 value will be sources
        int n = grid.length;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[n][n];
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();

        // Put all those sources to the queue at the start point
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    q.addLast(new Pair(row, col)); // adding all multiple source initially
                    visited[row][col] = true;      // marking all sources visited
                }
            }
        }

        // now start the BFS from all those sources as the same time
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair poll = q.removeFirst();
                int uRow = poll.row;
                int uCol = poll.col;

                for (int[] dir : dirs) {
                    int vRow = uRow + dir[0];
                    int vCol = uCol + dir[1];
                    if (vRow < 0 || vRow >= n || vCol < 0 || vCol >= n || visited[vRow][vCol]) continue;
                    visited[vRow][vCol] = true;
                    q.addLast(new Pair(vRow, vCol));
                    // here we have all those node that are reached first
                }
            }
        }
        return grid;
    }

    record Pair(Integer row, Integer col) {
    }
}
