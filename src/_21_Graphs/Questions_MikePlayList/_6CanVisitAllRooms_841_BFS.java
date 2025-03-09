package _21_Graphs.Questions_MikePlayList;

import java.util.*;

class _6CanVisitAllRooms_841_BFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int nV = rooms.size();

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[nV];

        q.addLast(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int u = q.removeFirst();

            for (int v : rooms.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.addLast(v);
                }
            }
        }

        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

}