package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.*;

public class _3Traversal_BFS {
    public static void main(String[] args) {
        int[][] edges = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        List<List<Integer>> adj = List.of(List.of(2, 3, 1), List.of(0), List.of(0, 4), List.of(0), List.of(2));

        ArrayList<Integer> dfs = bfsOfGraph(adj);
        System.out.println("dfs = " + dfs);
    }

    // ========================= using adj Lists(map) =========================
    private static ArrayList<Integer> bfsOfGraph(List<List<Integer>> adj) {
        // create map (tho we can use the given structure as well)
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int u = 0; u < adj.size(); u++) {
            for (Integer v : adj.get(u)) {
                map.computeIfAbsent(u, list -> new ArrayList<Integer>()).add(v);
            }
        }
        return bfs(adj.size(), map);
    }

    private static ArrayList<Integer> bfs(int size, HashMap<Integer, List<Integer>> map) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[size];
        ArrayList<Integer> ans = new ArrayList<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            ans.add(poll);
            for (Integer next : map.getOrDefault(poll, Collections.emptyList())) {
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(next);
            }
        }
        return ans;
    }

    // ========================= using adj matrix =========================
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        return solve(V, adj);
    }

    private ArrayList<Integer> solve(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[v];
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            ans.add(poll);

            for (Integer next : adj.get(poll)) {
                if (visited[next]) continue;
                visited[next] = true;
                q.offer(next);
            }
        }
        return ans;
    }
}
