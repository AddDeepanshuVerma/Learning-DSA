package POTD_LEETCODE.Tree;

import Random.AntonClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MostProfitablePath_2467 {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int[] amount = {-2, 4, 2, -4, 6};
        var obj = new MostProfitablePath_2467();
        System.out.println(obj.mostProfitablePath(edges, 3, amount));
    }

    private ArrayDeque<Integer> bobPath;
    private HashMap<Integer, List<Integer>> adj;
    private int aliceMoney;
    private int root;
    private int bob;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        /*
         * Steps:
         * First we will figure out the path of Bob and put it in a Stack/queue
         * Now we will start a BFS in Alice's path and get the maximum sum out of all leaf nodes inWhich
         * At each next Wave of BFS, bob goes towards 0
         * */
        aliceMoney = Integer.MIN_VALUE;
        this.bob = bob;
        root = 0;
        int n = amount.length;
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        bobPath = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        DFS_bob(bob, visited);

        // now while Travelling Alice we need to use RemoveFirst && peekFirst method of deQueue
        BFS_Alice(amount);
        return aliceMoney;
    }

    private void BFS_Alice(int[] amount) {
        ArrayDeque<int[]> q = new ArrayDeque<>(); // { currNode, parent, amount }
        int initialAmount;
        initialAmount = bob == root ? amount[root] >> 1 : amount[root];
        q.offer(new int[]{0, -1, initialAmount});

        while (!q.isEmpty()) {
            // here as we are starting with first step of Alice,lets begin Bob as well
            if (!bobPath.isEmpty()) amount[bobPath.removeFirst()] = 0;

            int size = q.size();
            while (size-- > 0) {
                int[] poll = q.poll();
                int u = poll[0], parent = poll[1], currAmount = poll[2];

                List<Integer> list = adj.get(u);
                if (list.size() == 1 && u != root) { // we are at leaf Node
                    aliceMoney = Math.max(aliceMoney, currAmount);
                }

                for (int v : list) {
                    if (v != parent) {
                        int deltaAmount = amount[v];
                        if (!bobPath.isEmpty() && bobPath.peekFirst() == v) {
                            deltaAmount >>= 1;
                        }
                        q.offer(new int[]{v, u, currAmount + deltaAmount});
                    }
                }
            }
        }

    }

    private boolean DFS_bob(int curr, boolean[] visited) {
        bobPath.offerLast(curr);
        visited[curr] = true;
        if (curr == 0) return true;

        for (Integer v : adj.get(curr)) {
            if (!visited[v]) {
                if (DFS_bob(v, visited)) {
                    return true;
                }
            }
        }
        bobPath.removeLast();
//        visited[curr] = false; // not need to unDo
        return false;
    }
}