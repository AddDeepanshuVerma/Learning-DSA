package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.*;

class _4isBipartite_BFS {
    public boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == -1 && sameColourDetected(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean sameColourDetected(int curr, int[][] graph, int[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(curr);
        visited[curr] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            int uColour = visited[u];

            for (int v : graph[u]) {
                if (visited[v] == uColour) return true;
                if (visited[v] == -1) {
                    visited[v] = 1 - uColour;
                    q.offer(v);
                }
            }
        }
        return false;
    }

    // if adj is given in form of HashMap
    private static boolean sameColourDetected(int curr, HashMap<Integer, List<Integer>> adj, int[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(curr);
        visited[curr] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            int uColour = visited[u];

            for (int v : adj.getOrDefault(u, Collections.emptyList())) {
                if (visited[v] == uColour) return true;
                if (visited[v] == -1) {
                    q.offer(v);
                    visited[v] = 1 - uColour;
                }
            }
        }
        return false;
    }

}