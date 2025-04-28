package _21_Graphs.Leetcode._3hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class FindAllPeople_2092_DSU_compact {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int[] meeting : meetings) {
            int u = meeting[0], v = meeting[1], t = meeting[2];
            map.computeIfAbsent(t, list -> new ArrayList<>()).add(new int[]{u, v});
        }

        union(0, firstPerson);
        for (List<int[]> list : map.values()) {
            for (int[] pair : list) {
                union(pair[0], pair[1]);
            }

            for (int[] pair : list) {
                int u = pair[0], v = pair[1];
                if (find(u) != find(0)) {
                    disjoint(u, v);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == find(0)) ans.add(i);
        }
        return ans;
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int root, int b) {
        int bParent = find(b);
        int rootParent = find(root);
        if (rootParent == bParent) return;
        parent[bParent] = rootParent;
    }

    private void disjoint(int a, int b) {
        parent[a] = a;
        parent[b] = b;
    }

}