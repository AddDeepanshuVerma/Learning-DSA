package POTD_LEETCODE.BFS;

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
                boolean present = bfs(a, b, map, visited);
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

    private boolean bfs(int source, int target, HashMap<Integer, List<Integer>> map, Set<Integer> visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(source);

        while (!q.isEmpty()) {
            int poll = q.poll();
            if (poll == target) return true;

            for (int next : map.getOrDefault(poll, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        return false;
    }


}