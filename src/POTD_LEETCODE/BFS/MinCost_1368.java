package POTD_LEETCODE.BFS;

import jdk.jfr.Description;

import java.util.Arrays;
import java.util.PriorityQueue;

class MinCost_1368 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}};
        int[][] grid2 = {{1, 2}, {4, 3}};
        int[][] grid3 = {{1, 1, 3}, {3, 2, 2}, {1, 1, 4}};
        System.out.println(minCost(grid));  // 3
        System.out.println(minCost(grid2)); // 0
        System.out.println(minCost(grid3)); // 1
    }

    public static int minCost(int[][] grid) {
        /*
         * we will make a priority queue with priority as lowest cost available
         * this queue will contain an array with length 3 -> {cost, row, col}
         * we will go through all possibilities of R-L-B-U where only the cost with same sign would be zero
         * rest will be +1 to existing cost.
         * Here we will enter in queue as {0,0,0} and explore
         * as soon as we get to the (m-1, n-1) index we got our cost as minimum answer
         * while traversing BFS :
         *   Here we will process queue item one by one instead of its size type.
         *   We need to maintain a visited 2D array so that we do not visit the same index again.
         *   Also put valid items in the queue, index has to be valid (i,j) parameter
         *  */
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, 0, 0});
        // 1,2,3,4 --> right, left, bottom, up

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cost = poll[0], i = poll[1], j = poll[2];
            if (visited[i][j]) continue;
            visited[i][j] = true;
            if (i == m - 1 && j == n - 1) { // we reached the bottom right index
                return cost;
            }
            // now need to explore all possible ways with valid cost
            // (i+1, j), (i-1, j), (i, j+1), (i, j-1)
            if (i + 1 < m && !visited[i + 1][j]) {
                int delta = grid[i][j] == 3 ? 0 : 1; // going bottom
                q.offer(new int[]{cost + delta, i + 1, j});
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                int delta = grid[i][j] == 4 ? 0 : 1; // going up
                q.offer(new int[]{cost + delta, i - 1, j});
            }
            if (j + 1 < n && !visited[i][j + 1]) {
                int delta = grid[i][j] == 1 ? 0 : 1; // going right
                q.offer(new int[]{cost + delta, i, j + 1});
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                int delta = grid[i][j] == 2 ? 0 : 1; // going left
                q.offer(new int[]{cost + delta, i, j - 1});
            }
        }
        return -1;
    }

    public static int minCost_compact(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cost = poll[0], i = poll[1], j = poll[2];
            if (visited[i][j]) continue;
            visited[i][j] = true;

            if (i == m - 1 && j == n - 1) { // we reached the bottom right index
                return cost;
            }
            // now need to explore all possible ways with valid cost Where : 1,2,3,4 --> right, left, bottom, up
            if (i + 1 < m && !visited[i + 1][j]) {
                q.offer(new int[]{cost + grid[i][j] == 3 ? 0 : 1, i + 1, j});
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                q.offer(new int[]{cost + grid[i][j] == 4 ? 0 : 1, i - 1, j});
            }
            if (j + 1 < n && !visited[i][j + 1]) {
                q.offer(new int[]{cost + grid[i][j] == 1 ? 0 : 1, i, j + 1});
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                q.offer(new int[]{cost + grid[i][j] == 2 ? 0 : 1, i, j - 1});
            }
        }
        return -1;
    }

    @Description("Here we didn't have to maintain visited 2dArray thinking we can visit the same index again if newCost is lower then previous visited cost ")
    public static int minCost_leetcode(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[][] costs = new int[m][n];
        for (int[] cost : costs) Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        que.offer(new int[]{0, 0, 0});
        costs[0][0] = 0;

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int row = poll[0], col = poll[1], cost = poll[2];
            if (row == m - 1 && col == n - 1) return cost; // reached the destination

            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                int newX = row + dir[0], newY = col + dir[1];

                if (newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
                // 1,2,3,4 --> right, left, bottom, up
                int newCost = cost + (i + 1 == grid[row][col] ? 0 : 1);
                if (newCost < costs[newX][newY]) {
                    costs[newX][newY] = newCost;
                    que.offer(new int[]{newX, newY, newCost});
                }
            }
        }
        return -1;
    }
}