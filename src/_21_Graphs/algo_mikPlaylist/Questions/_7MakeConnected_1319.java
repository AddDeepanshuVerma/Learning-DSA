package _21_Graphs.algo_mikPlaylist.Questions;

import java.util.HashSet;

class _7MakeConnected_1319 {
    /*
     * Steps:
     * first check if the given cables will be enough or not
     * required cables / given edges == total vertices - 1, then only we can connect all vertices
     *
     * If it is possible we just need to check number of different components we have :
     * we can use the DSU for that:
     * we will union all those vertices for which edges is given & maintain a parent array
     * In the parent array, number of different parents will show the number of components
     * Ans = number of components - 1;
     *
     * NOTE: While calculating the count of diff parent make sure to call find(i) for all to sync them with updated data
     * */

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

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        var obj = new _7MakeConnected_1319();
        System.out.println(obj.makeConnected(5, connections));
    }

    public int makeConnected(int n, int[][] connections) {
        int numOfEdges = connections.length;
        if (numOfEdges < n - 1) return -1;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
                union(u, v);
        }
        // now find the different parent so far
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            find(i); // to make sure every node's parent in updated
            set.add(parent[i]);
        }

        return set.size() - 1;
    }
}