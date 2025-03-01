package _21_Graphs.Leetcode;

import java.util.HashSet;

class _7MakeConnected_1319_compact {
    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        var obj = new _7MakeConnected_1319_compact();
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
                parent[find(connection[0])] = find(connection[1]);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));// to make sure every node's parent in updated
        }

        return set.size() - 1;
    }
}