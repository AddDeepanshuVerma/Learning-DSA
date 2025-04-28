package _21_Graphs.Leetcode._3hard;

import java.util.*;

//1- coded after reading some observation from others code & editorial
//:: letting both first and second visited array fill completely
class SecondMinimum_2045_Editorial {
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        int[] first = new int[n + 1], second = new int[n + 1];
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        first[1] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], ut = poll[1];

            ut = updateTime(ut, time, change);

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                if (ut < first[v]) {
                    second[v] = first[v];
                    first[v] = ut;
                    q.offer(new int[]{v, ut});
                } else if (ut > first[v] && ut < second[v]) {
                    second[v] = ut;
                    q.offer(new int[]{v, ut});
                }
            }
        }
        return second[n];   // letting both first and second visited array fill completely
    }

    private static int updateTime(int t, int time, int change) {
        if ((t / change & 1) == 1) { // odd timing hence redLight
            t = (t / change + 1) * change;
        }
        return t + time;
    }

    public static void main(String[] args) {
        int n = 5, time = 3, change = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int ans = secondMinimum(n, edges, time, change);
        System.out.println("ans = " + ans);
    }
}