package _21_Graphs.Leetcode._3hard;

import java.util.*;

class SortItems_1203 {
    // DOES NOT WORK AS WE NEED TO SORT THOSE TOPOLOGICAL SORTED ARRAY IN GROUP SORTED ORDER AS WELL :: TWO TOPOLOGICAL SORT
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<Integer> indegree = new ArrayList<>();
        for (int i = 0; i < n; i++) indegree.add(0);

        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < beforeItems.size(); i++) {
            int v = i;
            for (Integer u : beforeItems.get(i)) {
                adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
                indegree.set(v, indegree.get(v) + 1);
            }
        }

        indegree.sort((a, b) -> group[a] - group[b]);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.size(); i++) {
            if (indegree.get(i) == 0) {
                q.offer(i);
            }
        }
        int[] ans = new int[n];// topological sort order
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            ans[idx++] = u;

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                indegree.set(v, indegree.get(v) - 1);
                if (indegree.get(v) == 0) {
                    q.offer(v);
                }
            }
        }

        return idx == n ? ans : new int[]{};
    }

    public static void main(String[] args) {
        var obj = new SortItems_1203();
        int n = 8, m = 2;
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>(List.of(6)));
        beforeItems.add(new ArrayList<>(List.of(5)));
        beforeItems.add(new ArrayList<>(List.of(6)));
        beforeItems.add(new ArrayList<>(List.of(3, 6)));
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());

        int[] ans = obj.sortItems(n, m, group, beforeItems);
        System.out.println(Arrays.toString(ans));
    }
}