package _21_Graphs.Leetcode._3hard;

import java.util.HashSet;

class NumberOfSets_2959 {
    private int nv;
    private int count;
    private int maxDis;
    private int[][] edges;

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        count = 0;
        nv = n;
        edges = roads;
        maxDis = maxDistance;
        subset(0, new HashSet<Integer>(), n);
        return count;
    }

    private void subset(int i, HashSet<Integer> set, int n) {
        if (i >= n) {
            if (FloydWarshall(set)) {
                count++;
                System.out.println(set);
            }
            return;
        }

        set.add(i);
        subset(i + 1, set, n);
        set.remove(i);
        subset(i + 1, set, n);
    }

    private boolean FloydWarshall(HashSet<Integer> exclude) {
        int[][] grid = new int[nv][nv];
        // mark all diagonal === 0 & rest intMax
        for (int i = 0; i < nv; i++) {
            for (int j = 0; j < nv; j++) {
                if (i == j) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // now put given edges weights in 2d matrix
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (exclude.contains(u) || exclude.contains(v)) continue;
            grid[u][v] = Math.min(grid[u][v], w);
            grid[v][u] = Math.min(grid[v][u], w);
        }

        // now go from a->b using all possible nodes
        for (int k = 0; k < nv; k++) {
            for (int i = 0; i < nv; i++) {
                for (int j = 0; j < nv; j++) {
                    if (grid[i][k] == Integer.MAX_VALUE || grid[k][j] == Integer.MAX_VALUE) continue;
                    if (grid[i][k] + grid[k][j] < grid[i][j]) {
                        grid[i][j] = grid[i][k] + grid[k][j];
                    }
                }
            }
        }

        // now check that ALL those nodes which are includes has to have max distance <= maxDis

        for (int i = 0; i < nv; i++) {
            for (int j = 0; j < nv; j++) {
                if (!exclude.contains(i) && !exclude.contains(j)) {
                    if (grid[i][j] > maxDis) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        int maxDistance = 5;
        int[][] roads = {{0, 1, 2}, {1, 2, 10}, {0, 2, 10}};

        var obj = new NumberOfSets_2959();
        int res = obj.numberOfSets(n, maxDistance, roads);
        System.out.println("res = " + res);
    }

}