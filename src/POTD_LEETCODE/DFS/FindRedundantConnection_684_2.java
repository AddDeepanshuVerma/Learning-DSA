package POTD_LEETCODE.DFS;

import java.util.*;

class FindRedundantConnection_684_2 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        var obj = new FindRedundantConnection_684_2();
        System.out.println(Arrays.toString(obj.findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            Set<Integer> visited = new HashSet<>();
            if (map.containsKey(a) && map.containsKey(b) && dfs(a, b, map, new HashSet<>())) {
                return edge;
            } else {
                map.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
                map.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
            }
        }
        return null;
    }

    private boolean dfs(int source, int target, HashMap<Integer, List<Integer>> map, Set<Integer> visited) {
        visited.add(source);
        if (source == target) return true;

        for (int next : map.getOrDefault(source, Collections.emptyList())) {
            if (visited.contains(next)) continue;
            if (dfs(next, target, map, visited)) return true;
        }
        return false;
    }
}