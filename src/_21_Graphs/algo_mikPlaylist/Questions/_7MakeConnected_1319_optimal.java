package _21_Graphs.algo_mikPlaylist.Questions;

class _7MakeConnected_1319_optimal {
    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        var obj = new _7MakeConnected_1319_optimal();
        System.out.println(obj.makeConnected(5, connections));
    }

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
    } // no need

    // no need to use HashSet, we can simply calculate in while doing union
    public int makeConnected(int n, int[][] connections) {
        int numOfEdges = connections.length;
        if (numOfEdges < n - 1) return -1;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalComponents = n;
        for (int[] con : connections) {
            int a_Parent = find(con[0]);
            int b_Parent = find(con[1]);
            if (a_Parent != b_Parent) {
                parent[a_Parent] = b_Parent; // doing the union task here only
                totalComponents--;
            }
        }
        return totalComponents - 1;
    }
}