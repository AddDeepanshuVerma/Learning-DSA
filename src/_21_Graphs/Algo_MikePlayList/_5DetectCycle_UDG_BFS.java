package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _5DetectCycle_UDG_BFS {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        /* KeyPoints :
         * 1. As it is an UDG, we need to make sure that parent node of curr node does not prove to be a cycle
         * hence maintain a Parent NODE
         * 2. As we are doing BFS & we need to maintain a parent node for each node,
         * hence we have to store a pair in queue (pair : {node, its parent})
         * */
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            int parent = -1;
            if (!visited[i] && cycleDetected(i, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean cycleDetected(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        ArrayDeque<Pair<Integer, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(curr, -1));
        visited[curr] = true;

        while (!q.isEmpty()) {
            Pair<Integer, Integer> poll = q.poll();
            int node = poll.node();
            int parent = poll.parent();

            for (Integer next : adj.get(node)) {
                if (next == parent) continue;
                if (visited[next]) return true; // cycle detected
                visited[next] = true;
                q.offer(new Pair<>(next, node));
            }
        }

        return false;
    }

    private boolean cycleDetected2(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{curr, -1});
        visited[curr] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int node = poll[0];
            int parent = poll[1];

            for (Integer next : adj.get(node)) {
                if (next == parent) continue;
                if (visited[next]) return true; // cycle detected
                visited[next] = true;
                q.offer(new int[]{next, node});
            }
        }
        return false;
    }

    record Pair<K, V>(K node, V parent) {
    }
}
