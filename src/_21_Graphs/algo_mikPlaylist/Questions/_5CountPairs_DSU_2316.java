package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.HashMap;

class _5CountPairs_DSU_2316 {
    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        long ans = n;
        ans = (ans * (ans - 1)) >> 1;

        for (int[] edge : edges) {
            int parentU = find(edge[0]);
            int parentV = find(edge[1]);
            if (parentU != parentV) {
                parent[parentU] = parentV;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>(); // {component , nodes in this component}
        for (int i = 0; i < parent.length; i++) {
            int key = find(i);
            map.merge(key, 1, Integer::sum);
        }

        for (long value : map.values()) {
            ans -= (value * (value - 1)) >> 1;
        }
        return ans;
    }
}