package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.*;

class _1FindCircleNum_547 {
    public static void main(String[] args) {

        int[][] isConnected = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        /* Points :
         * It is an unDirected graph & Yes there can be cycles in Graph.
         * We need to calculate how many components are there :
         * Approach : make the adjLists, maintain a visited array
         * Run a loop from 1 till size of grid & run to its all neighbours
         * Count number of time we had to run it
         * */

        int n = isConnected.length;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (isConnected[i][j] == 1) {
                    adj.computeIfAbsent(i + 1, list -> new ArrayList<>()).add(j + 1);
                }

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
//                dfs(i, adj, visited);
                bfs(i, adj, visited);
            }
        }
        return count;
    }

    private static void bfs(int curr, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(curr);
        visited[curr] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                if (visited[v]) continue;
                visited[v] = true;
                q.offer(v);
            }
        }
    }

    private static void dfs(int curr, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        if (visited[curr]) return;
        visited[curr] = true;

        for (Integer next : adj.getOrDefault(curr, Collections.emptyList())) {
            if (visited[next]) continue;
            dfs(next, adj, visited);
        }
    }
}