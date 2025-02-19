package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayList;
import java.util.List;

public class _2Traversal_DFS_2 {
    public static void main(String[] args) {
        int[][] edges = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(2, 3, 1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));

        ArrayList<Integer> dfs = dfsOfGraph(adj);
        System.out.println("dfs = " + dfs);
    }

    private static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // create map ( tho we can use the given structure as well)
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        int startingNode = 0;
        dfs(startingNode, adj, visited, ans);

        return ans;
    }

    private static void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        if (visited[curr]) return;

        visited[curr] = true;
        ans.add(curr);

        for (Integer next : adj.get(curr)) {
            dfs(next, adj, visited, ans);
        }
    }
}
