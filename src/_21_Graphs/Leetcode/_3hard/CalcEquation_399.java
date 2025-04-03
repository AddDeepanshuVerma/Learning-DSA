package _21_Graphs.Leetcode._3hard;

import java.util.*;

class CalcEquation_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> adj = new HashMap<>(); // stores : u -> {v, w}

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            double w = values[i];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new Pair(v, w));
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(new Pair(u, 1 / w));
        }

        // now for each query we simply need to run a BFS for finding the target
        double[] ans = new double[queries.size()];
        HashSet<String> visited;
        for (int i = 0; i < queries.size(); i++) {
            visited = new HashSet<>();
            ans[i] = dfs((double) 1, queries.get(i).get(0), queries.get(i).get(1), adj, visited);
        }

        return ans;
    }

    private double dfs(double curr, String src, String target, HashMap<String, List<Pair>> adj, HashSet<String> visited) {
        visited.add(src);
        if (adj.containsKey(src) && src.equals(target)) {
            return curr;
        }

        for (Pair ngbr : adj.getOrDefault(src, Collections.emptyList())) {
            String v = ngbr.str();
            double w = ngbr.weight();
            if (visited.contains(v)) continue;
            double dfs = dfs(curr * w, v, target, adj, visited);
            if (dfs != -1) return dfs;
        }
        return (double) -1;
    }

    record Pair(String str, double weight) {
    }

    public static void main(String[] args) {
        List<List<String>> equations = List.of(Arrays.asList("x1", "x2"), Arrays.asList("x2", "x3"), Arrays.asList("x3", "x4"), Arrays.asList("x4", "x5"));
        double[] values = {3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = List.of(Arrays.asList("x2", "x4"));

        var obj = new CalcEquation_399();
        double[] ans = obj.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ans));
    }
}