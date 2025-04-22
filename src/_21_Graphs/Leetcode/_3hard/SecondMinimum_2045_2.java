package _21_Graphs.Leetcode._3hard;

import java.util.*;

//visiting each node only two times :  43 / 77 testcases passed
class SecondMinimum_2045_2 {
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        int destination = n;
        TreeSet<Integer> reach = new TreeSet<>();

        ArrayDeque<int[]> q = new ArrayDeque<>(); // {node, when we started to move away from this node to another}
        q.offer(new int[]{1, 0});

        HashMap<Integer, Integer> visited = new HashMap<>();
        visited.merge(1, 1, Integer::sum);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] poll = q.poll();
                int u = poll[0];
                int ut = poll[1];
                if (u == destination) {
                    reach.add(ut); // & still explore more if size is still < 2
                    if (reach.size() == 2) break;
                }

                for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                    // can visit the same node twice only!!!
                    if (visited.merge(v, 1, Integer::sum) > 2) continue;
                    int wantToMove = ut + time;
                    if (((ut / change) & 1) == 1) { // if it is odd, means we are at red signal
                        wantToMove = ((ut / change) + 1) * change + time;
                    }
                    q.offer(new int[]{v, wantToMove});
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