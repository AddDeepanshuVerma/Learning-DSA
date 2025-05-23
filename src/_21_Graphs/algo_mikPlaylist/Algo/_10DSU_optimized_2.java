package _21_Graphs.algo_mikPlaylist.Algo;

public class _10DSU_optimized_2 {
    int[] parent; // needs to be initialized before use
    int[] rank;   // needs to be initialized before use

    /* To optimize we do the path compression which means is that all the crossed vertexes parent would be same*/
    private int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    /* Applying rank structure to make the internal tree depth as minimum as possible  */
    void union(int a, int b) {
        int a_parent = find(a);
        int b_parent = find(b);

        if (a_parent != b_parent) {
            if (rank[a_parent] == rank[b_parent])
                rank[a_parent]++;
            if (rank[b_parent] > rank[a_parent]) {
                int temp = a_parent;
                a_parent = b_parent;
                b_parent = temp;
            }
            parent[b_parent] = a_parent;
        }
    }
}
