package POTD_LEETCODE.Graph.DSU;

class CountCompleteComponents_2685_2_3 {
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        countEdge = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        // union edges
        for (int[] edge : edges) union(edge[0], edge[1]);
        // now we know all components parent,size,edges
        int count = 0;
        for (int i = 0; i < n; i++) {
            int nv = size[i], neededEdges = nv * (nv - 1) >> 1;
            if (parent[i] == i && neededEdges == countEdge[i]) {
                count++;
            }
        }
        return count;
    }

    int[] parent;
    int[] size;
    int[] countEdge;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);

        if (aParent == bParent) {
            countEdge[aParent]++;
        } else {
            size[aParent] += size[bParent];
            countEdge[aParent] += countEdge[bParent] + 1;
            parent[bParent] = aParent;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2}, {3, 4}, {1, 4}, {2, 3}, {1, 3}, {2, 4}};
        var obj = new CountCompleteComponents_2685_2_3();
        System.out.println(obj.countCompleteComponents(n, edges));
    }
}