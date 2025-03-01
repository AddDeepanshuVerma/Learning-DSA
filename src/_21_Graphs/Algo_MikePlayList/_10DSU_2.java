package _21_Graphs.Algo_MikePlayList;

public class _10DSU_2 {
    int[] parent; // needs to be initialized before use


    /* Finds us the ultimate parent of the set, ith first belongs to, Time complexly = O(n) */
    private int find(int i) {
        if (i != parent[i]) {
            return parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    /* Union the two vertices into a same component only if they are from different one, Time complexity = O(1) */
    void union(int a, int b) {
        parent[find(b)] = find(a);
    }
}
