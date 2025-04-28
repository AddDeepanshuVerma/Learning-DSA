package _21_Graphs.Leetcode._3hard;

import java.util.*;

class SortItems_1203_2 {
    // STOREY TO CODE: WORK AS EXPECTED AS WE SORTED THOSE TOPOLOGICAL SORTED ITEMS AGAIN BASES ON THE TOPOLOGICAL SORTING OF GROUPS
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }

        HashMap<Integer, List<Integer>> adjItems = new HashMap<>();
        HashMap<Integer, List<Integer>> adjGroups = new HashMap<>();

        for (int i = 0; i < beforeItems.size(); i++) {
            int v = i;
            int vGroup = group[v];
            for (int u : beforeItems.get(v)) {
                adjItems.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
                int uGroup = group[u];
                if (uGroup != vGroup) {
                    adjGroups.computeIfAbsent(uGroup, list -> new ArrayList<>()).add(vGroup);
                }
            }
        }

        List<Integer> sortItems = topologicalSort(n, adjItems);
        List<Integer> sortGroups = topologicalSort(m, adjGroups);

        LinkedHashMap<Integer, List<Integer>> groupToItems = new LinkedHashMap<>(); // group -> list of items
        for (int grp : sortGroups) {
            groupToItems.computeIfAbsent(grp, List -> new ArrayList<>());
        }
        for (int item : sortItems) {
            if (groupToItems.containsKey(group[item])) {
                groupToItems.get(group[item]).add(item);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (List<Integer> list : groupToItems.values()) {
            ans.addAll(list);
        }

        int i = 0;
        int[] res = new int[ans.size()];
        for (Integer val : ans) res[i++] = val;

        return res;
    }

    private List<Integer> topologicalSort(int n, HashMap<Integer, List<Integer>> adj) {
        int[] indegree = new int[n];
        for (List<Integer> list : adj.values()) {
            for (Integer val : list) {
                indegree[val]++;
            }
        }

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
        var obj = new SortItems_1203_2();
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