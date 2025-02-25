package _21_Graphs.Algo_MikePlayList;

public class _12DSU_numberOfComponents {
    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int i, int j) {
        int i_parent = find(i);
        int j_parent = find(j);
        if (i_parent != j_parent) {
            parent[j_parent] = i_parent;
        }
    }

    public int numOfComponents(int n, int[][] connections) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalComponents = n;
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            if (find(u) != find(v)) {
                union(u, v);
                totalComponents--; // two components merger here
            }
        }
        return totalComponents;
    }
}
