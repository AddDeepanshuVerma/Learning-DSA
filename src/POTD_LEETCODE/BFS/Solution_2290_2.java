package POTD_LEETCODE.BFS;

import jdk.jfr.Description;

import java.util.PriorityQueue;

class Solution_2290_2 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(minimumObstacles(grid));
    }


    @Description("BFS + priorityQueue might be useful")
    public static int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        char[][] visited = new char[m][n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(0, 0, grid[0][0]));
        visited[0][0] = 'v';

        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Pair remove = pq.remove();
            int row = remove.row, col = remove.col, weight = remove.weight;
            if (row == m - 1 && col == n - 1) {
                return weight;
            }

            if (row + 1 < m && visited[row + 1][col] != 'v') {
                pq.add(new Pair(row + 1, col, weight + grid[row + 1][col]));
                visited[row + 1][col] = 'v';
            }
            if (col + 1 < n && visited[row][col + 1] != 'v') {
                pq.add(new Pair(row, col + 1, weight + grid[row][col + 1]));
                visited[row][col + 1] = 'v';
            }
            if (row - 1 >= 0 && visited[row - 1][col] != 'v') {
                pq.add(new Pair(row - 1, col, weight + grid[row - 1][col]));
                visited[row - 1][col] = 'v';
            }
            if (col - 1 >= 0 && visited[row][col - 1] != 'v') {
                pq.add(new Pair(row, col - 1, weight + grid[row][col - 1]));
            }
        }
        return -1;
    }

    record Pair(int row, int col, int weight) {
    }
}

