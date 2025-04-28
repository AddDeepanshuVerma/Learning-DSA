package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class _6CanVisitAllRooms_841_DFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nV = rooms.size();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int u = 0; u < rooms.size(); u++) {
            for (int v : rooms.get(u)) {
                adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            }
        }

        boolean[] visited = new boolean[nV];
        int start = 0;
        dfs(start, adj, visited);

        for (boolean flag : visited) {
            if (!flag) return false; // if anyNode remained unvisited then we could not visit all room hence return false
        }

        return true;
    }

    private void dfs(int curr, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        if (visited[curr]) return;
        visited[curr] = true;

        for (int next : adj.getOrDefault(curr, Collections.emptyList())) {
            dfs(next, adj, visited);
        }
    }
}