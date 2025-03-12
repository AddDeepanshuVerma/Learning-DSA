package _21_Graphs.Leetcode._2medium;

import java.util.List;

class _6CanVisitAllRooms_841_DFS_2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nV = rooms.size();
        boolean[] visited = new boolean[nV];
        dfs(0, rooms, visited); // source is given in problem === 0

        for (boolean flag : visited) {
            if (!flag) return false; // if anyNode remained unvisited then we could not visit all room hence return false
        }

        return true;
    }

    private void dfs(int curr, List<List<Integer>> adj, boolean[] visited) {
        if (visited[curr]) return;
        visited[curr] = true;

        for (int next : adj.get(curr)) {
            dfs(next, adj, visited);
        }
    }
}