package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _7TopologicalSort_DFS {
    static ArrayList<Integer> topologicalSort_Stack(ArrayList<ArrayList<Integer>> adj) {
        /*
        * KeyPoints
        * 1. Topological sort is sorted in u --> v manner hence Graph has to be "DIRECTED GRAPH"
        * 2. Also, if there exists a cycle in a graph we can not sort it as  u --> v && v --> u.
        * 3. Hence, to apply "TOPOLOGICAL SORT, GRAPH HAS TO BE DIRECTED & ACYCLIC"
        * 4. WE CAN APPLY TOPOLOGICAL SORT IN A DAG (DIRECTED ACYCLIC GRAPH).
        * WTD:
        * Here in topological sort we sort the nodes in such way that it satisfy any edge in the given graph
        * Means : we first store the children of node and then store the children in the stack, later just pop the stack to a list.
        * */

        int vertices = adj.size();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) ans.add(stack.pop());
        return ans;
    }

    private static void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayDeque<Integer> stack) {
        visited[curr] = true;

        for (Integer next : adj.get(curr)) {
            if (visited[next]) continue;
            dfs(next, adj, visited, stack);
        }
        stack.push(curr);
    }

    // It's not optimal compare to stack one
    static ArrayList<Integer> topologicalSort_List(ArrayList<ArrayList<Integer>> adj) {
        /*
         * KeyPoints
         * Here in topological sort we sort the nodes in such way that it satisfy any edge in the given graph
         * Means : we first store the children of node and then store the children in the stack, later just pop the stack to a list.
         * To do the same : we store the elements on first index each time, it someHow replicated the BFS waves.
         * */
        int vertices = adj.size();
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, ans);
            }
        }
        return ans;
    }

    private static void dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[curr] = true;
        for (Integer next : adj.get(curr)) {
            if (visited[next]) continue;
            dfs(next, adj, visited, ans);
        }
        ans.add(0, curr);
    }
}
