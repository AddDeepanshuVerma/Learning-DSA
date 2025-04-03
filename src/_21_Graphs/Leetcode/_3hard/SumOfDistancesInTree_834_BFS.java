package _21_Graphs.Leetcode._3hard;

import java.util.*;

class SumOfDistancesInTree_834_BFS {

    private HashMap<Integer, List<Integer>> adj;

    // TC : V^3 === 64 / 74 testcases passed
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        /*
         * Steps: Here we could have applied dijkstra algorithm to find the shortest path in case of weighted graph
         * but as per prob statement: we can assume all weights to be 1 hence we can apply simple BFS approach
         * Hence Apply simple BFS approach for all sources one by one and store their sum's getValue in required
         * array to return
         * PROBLEM : TIME Complexity of this approach : bfs on each node = bfs * nV = O(V+E) * V === V^3
         * */
        int[] ans = new int[n];
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }

        for (int i = 0; i < n; i++) {
            ans[i] = getSum(i, n);
        }
        return ans;
    }

    private int getSum(int node, int nV) {
        int sum = 0;

        boolean[] visited = new boolean[nV];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[node] = true;
        q.addLast(node);
        int level = 0;
        sum += level;

        while (!q.isEmpty()) {
            int size = q.size();
            level++; // at each new wave distance is increasing by 1

            while (size-- > 0) {
                int u = q.removeFirst();
                for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                    if (!visited[v]) {
                        visited[v] = true;
                        sum += level;
                        q.addLast(v);
                    }
                }
            }

        }
        return sum;
    }

    private int getSum2(int node, int nV) {
        int[] dis = new int[nV];
        Arrays.fill(dis, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int level = 0;
        dis[node] = level;
        q.addLast(node);

        while (!q.isEmpty()) {
            int size = q.size();
            level++; // at each new wave distance is increasing by 1

            while (size-- > 0) {
                int u = q.removeFirst();

                for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                    if (dis[v] == -1) {
                        q.addLast(v);
                        dis[v] = level;
                    }
                }
            }

        }
        System.out.print("node" + node + " dis[] : ");
        System.out.println(Arrays.toString(dis));
        // now we have all the distance present in dis[] array
        int sum = 0;
        for (int d : dis) {
            sum += d;
        }
        return sum;
    }
}