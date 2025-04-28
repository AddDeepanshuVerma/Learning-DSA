package POTD_LEETCODE.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MostProfitablePath_2467_2 {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int[] amount = {-2, 4, 2, -4, 6};
        var obj = new MostProfitablePath_2467_2();
        System.out.println(obj.mostProfitablePath(edges, 3, amount));
    }

    private int ans;
    private HashMap<Integer, Integer> time;
    private HashMap<Integer, List<Integer>> adj;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ans = Integer.MIN_VALUE;
        int n = amount.length;
        time = new HashMap<>();
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        int t = 0;
        boolean[] visited = new boolean[n];
        dfsBob(t, bob, visited);

        visited = new boolean[n];
        dfsAlice(0, 0, 0, amount, visited);

        return ans;
    }

    private void dfsAlice(int curr, int t, int income, int[] amount, boolean[] visited) {
        visited[curr] = true;

        if (!time.containsKey(curr) || t < time.get(curr)) {
            income += amount[curr];
        } else if (t == time.get(curr)) {
            income += amount[curr] >> 1;
        }

        List<Integer> list = adj.get(curr);
        if (list.size() == 1 && curr != 0) {
            ans = Math.max(ans, income);
        }

        for (Integer v : list) {
            if (!visited[v]) {
                dfsAlice(v, t + 1, income, amount, visited);
            }
        }
    }

    private boolean dfsBob(int t, int curr, boolean[] visited) {
        time.put(curr, t);
        visited[curr] = true;
        if (curr == 0) return true;

        for (Integer v : adj.get(curr)) {
            if (!visited[v]) {
                if (dfsBob(t + 1, v, visited)) {
                    return true;
                }
            }
        }
        time.remove(curr);
        return false;
    }
}