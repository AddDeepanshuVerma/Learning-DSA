package _21_Graphs.Algo_MikePlayList;

import java.util.*;

public class _2Traversal_DFS {
    public static void main(String[] args) {
        int[][] edges = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        List<List<Integer>> adj = List.of(List.of(2, 3, 1), List.of(0), List.of(0, 4), List.of(0), List.of(2));

        ArrayList<Integer> dfs = dfsOfGraph(adj);
        System.out.println("dfs = " + dfs);
    }

    private static ArrayList<Integer> dfsOfGraph(List<List<Integer>> adj) {
        // create map ( tho we can use the given structure as well)
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int u = 0; u < adj.size(); u++) {
            for (Integer v : adj.get(u)) {
                map.computeIfAbsent(u, list -> new ArrayList<Integer>()).add(v);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        int startingNode = 0;
        dfs(startingNode, map, visited, ans);

        return ans;
    }

    private static void dfs(int curr, HashMap<Integer, List<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        if (visited[curr] ==  true) {
            return;
        }
        visited[curr] = true;
        ans.add(curr);

        for (Integer next : adj.getOrDefault(curr, Collections.emptyList())) {
            dfs(next, adj, visited, ans);
        }
    }
}
