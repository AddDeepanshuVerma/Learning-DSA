package POTD_LEETCODE.DFS;

import java.util.*;

class FindRedundantConnection_684 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        var obj = new FindRedundantConnection_684();
        System.out.println(Arrays.toString(obj.findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (!map.containsKey(a) || !map.containsKey(b)) {
                map.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
                map.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
            } else {
                Set<Integer> visited = new HashSet<>(List.of(a));
                boolean present = dfs(a, b, map, visited);
                if (present) {
                    return edge;
                } else {
                    map.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
                    map.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
                }
            }
        }
        return null;
    }

    private boolean dfs(int source, int target, HashMap<Integer, List<Integer>> map, Set<Integer> visited) {
        if (source == target) return true;

        boolean present = false;
        for (int next : map.getOrDefault(source, Collections.emptyList())) {
            if (visited.contains(next)) continue;
            visited.add(next);
            present = dfs(next, target, map, visited);
            if (present) return true;
        }
        return present;
    }

    private boolean dfs2(int source, int target, HashMap<Integer, List<Integer>> map, Set<Integer> visited) {
        if (source == target) return true;
        visited.add(source);

        for (int next : map.getOrDefault(source, Collections.emptyList())) {
            if (visited.contains(next)) continue;
            if (dfs2(next, target, map, visited)) return true;
        }
        return false;
    }
}