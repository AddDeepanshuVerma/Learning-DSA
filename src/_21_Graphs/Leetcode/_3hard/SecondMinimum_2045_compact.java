package _21_Graphs.Leetcode._3hard;

import java.util.*;

//same as previously passed but slightly compact & concise
class SecondMinimum_2045_compact {
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        TreeSet<Integer> reach = new TreeSet<>();
        ArrayDeque<int[]> q = new ArrayDeque<>(); // {node, when we started to move away from this node to another}
        q.offer(new int[]{1, 0});

        HashMap<Integer, HashSet<Integer>> visited = new HashMap<>(); // {node, {distinct weights}}
        visited.computeIfAbsent(1, set -> new HashSet<>()).add(0);

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], ut = poll[1];
            if (u == n) {
                reach.add(ut);
                if (reach.size() == 2) break;
            }

            for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                int delta = ut;
                if (((delta / change) & 1) == 1) { // if it is odd, means we are at red signal
                    delta = ((delta / change) + 1) * change;
                }
                int vt = delta + time;
                visited.putIfAbsent(v, new HashSet<>());
                HashSet<Integer> set = visited.get(v);
                if (set.add(vt) && set.size() < 3) {
                    q.offer(new int[]{v, vt});
                }
            }
        }

        reach.removeFirst();
        return !reach.isEmpty() ? reach.removeFirst() : -1;
    }

    public static void main(String[] args) {
        int n = 5, time = 3, change = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
//        int n = 2, time = 3, change = 2;
//        int[][] edges = {{1, 2}};
        int ans = secondMinimum(n, edges, time, change);
        System.out.println("ans = " + ans);
    }
}