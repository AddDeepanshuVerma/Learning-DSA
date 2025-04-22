package _21_Graphs.Leetcode._3hard;

import java.util.*;

//visiting each node any number of times : 1 / 77 testcases passed
class SecondMinimum_2045 {
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        /*
         * Approach :
         *  We would not run dijkstra but a BFS as we need the second minimal time to reach destination
         *  As BFS gives us the freedom to travel each possibility of reaching the desired node with various weight/time
         *  While traversing BFS it makes sure that we reach the target with the shortest path also explores all possibilities
         *  Hence whenever our poll node reaches the destination we will store the node's time in an TreeSet also we need to make sure that
         *  as we will be exploring each possibility but not visit the same node with same time again &  also not visit the parent node
         *  Rest we can enjoy filling our treeSet, or we can also break the whileLoop when treeSet.size == 2
         *
         *  Later changes:
         *  we can even visit the parent node as what if there are only single edge from 1 -> 2 Hence for second minimal time we have to go
         *  1 -> 2 -> 1 -> 2 but to tackle a new problem we will make sure to do a wave type BFS
         * */

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
//        no need of seen as we can even visit the parent of current node again
//        HashSet<String> seen = new HashSet<>();
//        seen.add(1 + "_" + 0);
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
                    int wantToMove = ut + time;
                    // now check when we are reaching v with vt, what is the light for signal crossing
                    // ep we reach at node 4 on time = 6
                    // but 6/change = 6/5 === odd, means we reach at odd time hence we have to wait till its even.
                    // Even time would be change * (odd + 1) = 5 * (1 + 1) = 10
                    // Hence next node visited time would be 10
                    if (((ut / change) & 1) == 1) { // if it is odd, means we are at red signal
                        wantToMove = ((ut / change) + 1) * change + time;
                    }
                    q.offer(new int[]{v, wantToMove});
                }
            }
        }

        if (reach.size() < 2) return -1;
        reach.removeFirst();
        return reach.removeFirst();
    }

    public static void main(String[] args) {
//        int n = 5, time = 3, change = 5;
//        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int n = 2, time = 3, change = 2;
        int[][] edges = {{1, 2}};
        int ans = secondMinimum(n, edges, time, change);
        System.out.println("ans = " + ans);
    }
}