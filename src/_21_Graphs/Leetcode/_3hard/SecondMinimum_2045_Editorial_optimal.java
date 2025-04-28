package _21_Graphs.Leetcode._3hard;

import java.util.*;

// 4- coded after reading some observation from others code & editorial
// simply use List<List<Integer>> instead of HashMap
class SecondMinimum_2045_Editorial_optimal {
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] first = new int[n + 1], second = new int[n + 1];
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        first[1] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], ut = updateTime(poll[1], time, change);

            for (Integer v : adj.get(u)) {
                if (ut < first[v]) {
                    second[v] = first[v];
                    first[v] = ut;
                    q.offer(new int[]{v, ut});
                } else if (ut > first[v] && ut < second[v]) {
                    if (v == n) return ut;
                    second[v] = ut;
                    q.offer(new int[]{v, ut});
                }
            }
        }
        return -1;
    }

    private static int updateTime(int ut, int time, int change) {
        if ((ut / change & 1) == 1) { // odd timing hence redLight is on
            ut = (ut / change + 1) * change;
        }
        return ut + time;
    }

    public static void main(String[] args) {
        int n = 5, time = 3, change = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int ans = secondMinimum(n, edges, time, change);
        System.out.println("ans = " + ans);
    }
}