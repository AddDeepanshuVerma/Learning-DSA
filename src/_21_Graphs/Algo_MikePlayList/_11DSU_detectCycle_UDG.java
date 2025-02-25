package _21_Graphs.Algo_MikePlayList;

import java.util.ArrayList;
import java.util.List;

public class _11DSU_detectCycle_UDG {

    private int[] parent;
    private int[] rank;

    private int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private void union(int a, int b) {
        int a_parent = find(a);
        int b_parent = find(b);
        if (a_parent == b_parent)
            return;

        if (rank[a_parent] < rank[b_parent]) {
            parent[a_parent] = b_parent;
        } else if (rank[b_parent] < rank[a_parent]) {
            parent[b_parent] = a_parent;
        } else {
            parent[b_parent] = a_parent;
            rank[a_parent]++;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(3, 2, 4)));
        adj.add(new ArrayList<>(List.of(3)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(1, 0)));
        adj.add(new ArrayList<>(List.of(0, 2)));
        var obj = new _11DSU_detectCycle_UDG();
        System.out.println(obj.detectCycle(5, adj));

    }

    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        parent = new int[V];
        rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                if (u < v) {
                    int u_parent = find(u);
                    int v_parent = find(v);
                    if (u_parent == v_parent)
                        return 1; // cycle is detected as we are trying to union them but they are already union(in a single set)
                    union(u, v);
                }
            }
        }
        return 0;
    }
}
