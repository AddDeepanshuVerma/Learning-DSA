package _21_Graphs.Leetcode._3hard;

import java.util.*;

class SortItems_1203_4 {
    // SAME AS _2 but concise + compact + hence less readable + more optimized
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }

        HashMap<Integer, List<Integer>> adjItems = new HashMap<>();
        HashMap<Integer, List<Integer>> adjGroups = new HashMap<>();
        int[] indegreeItems = new int[n];
        int[] indegreeGroups = new int[m];

        for (int i = 0; i < beforeItems.size(); i++) {
            int v = i;
            int vGroup = group[v];
            for (int u : beforeItems.get(v)) {
                adjItems.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
                indegreeItems[v]++;
                int uGroup = group[u];
                if (uGroup != vGroup) {
                    adjGroups.computeIfAbsent(uGroup, list -> new ArrayList<>()).add(vGroup);
                    indegreeGroups[vGroup]++;
                }
            }
        }

        List<Integer> sortItems = topologicalSort(n, indegreeItems, adjItems);
        List<Integer> sortGroups = topologicalSort(m, indegreeGroups, adjGroups);
        if (sortItems.isEmpty() || sortGroups.isEmpty()) return new int[]{};        // no further calculations needed

        HashMap<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (Integer item : sortItems) {
            groupToItems.computeIfAbsent(group[item], list -> new ArrayList<>()).add(item);
        }
        List<Integer> ans = new ArrayList<>();
        for (Integer grp : sortGroups) {
            ans.addAll(groupToItems.getOrDefault(grp, Collections.emptyList()));
        }

        int idx = 0;
        int[] res = new int[n];
        for (Integer val : ans) res[idx++] = val;

        return res;
    }

    private List<Integer> topologicalSort(int n, int[] indegree, HashMap<Integer, List<Integer>> adj) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            ans.add(u);

            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return ans.size() == n ? ans : new ArrayList<>();
    }

    public static void main(String[] args) {
        var obj = new SortItems_1203_4();
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