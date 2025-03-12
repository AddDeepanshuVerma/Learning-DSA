package _21_Graphs.Leetcode._2medium;

import java.util.HashSet;
import java.util.List;

class _6CanVisitAllRooms_841_DFS_3 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nV = rooms.size();
        HashSet<Integer> seen = new HashSet<>();
        dfs(0, rooms, seen);
        return seen.size() == nV;
    }

    private void dfs(int curr, List<List<Integer>> adj, HashSet<Integer> seen) {
        if (seen.add(curr)) {
            for (int next : adj.get(curr)) {
                dfs(next, adj, seen);
            }
        }
    }
}