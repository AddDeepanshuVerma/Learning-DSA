package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class _3Traversal_BFS {
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
        ArrayList<Integer> ans = bfs(map);
        return ans;
    }

    private static ArrayList<Integer> bfs(HashMap<Integer, List<Integer>> map) {
        return null;
    }

}
