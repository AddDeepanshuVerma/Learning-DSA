package _21_Graphs.Leetcode._3hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class FindAllPeople_2092_DSU {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // First lets have all meeting lined up as per time in asc order
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int[] meeting : meetings) {
            int u = meeting[0], v = meeting[1], t = meeting[2];
            map.computeIfAbsent(t, list -> new ArrayList<>()).add(new int[]{u, v});
        }
        // DSU preRequisite
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        // now let make 0 & firstPerson belong to same group
        union(0, firstPerson);
        // now lets go through given timeLine & check if any set contains a node that has same parent as 0
        // and if it does, union all those elements in that set with 0

        for (List<int[]> list : map.values()) {
            // first union nodes of this list
            for (int[] pair : list) {
                union(pair[0], pair[1]);
            }

            // later disjoint those nodes which parent's is not same 0 parents
            // as later we need then to be individual to be formed again
            for (int[] pair : list) {
                int u = pair[0], v = pair[1];
                if (find(u) != find(0)) {
                    disjoint(v);
                    disjoint(u);
                }
            }
        }

        //lastly we simply need to return all those nodes which has same parent == 0
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == find(0)) {
                ans.add(i);
            }
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

    private void disjoint(int i) {
        parent[i] = i;
    }

}