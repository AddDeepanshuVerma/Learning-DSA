package _21_Graphs.Algo_MikePlayList;

public class _10DSU {
    int[] parent; // needs to be initialized before use


    /* Finds us the ultimate parent of the set, ith node belongs to, Time complexly = O(n) */
    private int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return find(parent[i]);
    }

    /* Union the two vertices into a same component only if they are from different one, Time complexity = O(1) */
    void union(int a, int b) {
        int a_parent = find(a);
        int b_parent = find(b);

        if (a_parent != b_parent) {
            parent[b_parent] = a_parent;
        }
    }
}
