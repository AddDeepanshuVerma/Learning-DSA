package _21_Graphs.Leetcode._2medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class MinReorder_1466_DFS {

    private HashMap<Integer, List<int[]>> adj;

    public int minReorder(int n, int[][] connections) {
        /*
         * Approach:
         * As we want to spread from/to 0 towards other but some path are inverse & wouldn't let us do so being it a Directed Graph
         * Hence let's add make this Graph unDirected means we are adding an edge by ourselves
         * Here now we will spread out from 0 and if we use our added path means that existed path for those same edges was going towards 0
         * Means in this question, all other cities want to move towards 0 and this path itself moving to 0
         * Hence it will not be counted
         * Brief: When we are spreading from 0 to others and using our added path means given was correct but if we are using given paths
         *        means added one was going towards 0 and this edges needs to be flipped (count++)
         * To figure out which one is given and which one is added we can weight those edges
         * (given weight = 1; if had to use given while spreading out of 0, we have to flip it to go towards 0 hence add this weight)
         * (added weight = 0; if had to use added while spreading out of 0, we don't need to fip it to go towards 0 hence add 0 weight)
         * */

        adj = new HashMap<>();// {u -> (v,w),.,.}
        for (int[] connection : connections) {
            int u = connection[0], v = connection[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, 1});// given edge
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[]{u, 0});// added edge
        }

        int start = 0, parent = -1;
        return dfs(start, parent);
    }

    private int dfs(int u, int parent) {
        int count = 0;
        for (int[] next : adj.getOrDefault(u, Collections.emptyList())) {
            int v = next[0], vw = next[1];
            if (v == parent) continue; // not exploring backSide again
            count += vw + dfs(v, u);
        }
        return count;
    }
}