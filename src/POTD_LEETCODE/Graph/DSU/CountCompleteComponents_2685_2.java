package POTD_LEETCODE.Graph.DSU;

class CountCompleteComponents_2685_2 {
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        countEdge = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            //countEdge[i] = 0;
        }
        // union edges
        for (int[] edge : edges) union(edge[0], edge[1]);
        // now we know all components parent,size,edges
        int[] numOfNodes = new int[n];
        for (int i = 0; i < parent.length; i++) {
            numOfNodes[find(i)]++;
        }

        int count = 0;
        for (int i = 0; i < numOfNodes.length; i++) {
            if (numOfNodes[i] == 0) continue;
            int nv = size[i], e = countEdge[i];
            if (nv <= 2 || e == (nv * (nv - 1)) >> 1) {
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
            return;
        }
        // new parents size increases by another small component that's getting union
        size[aParent] += size[bParent];
        // no of edges will also increase
        countEdge[aParent] += countEdge[bParent] + 1;
        // now a can finally be a parent of whole Group
        parent[bParent] = aParent;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2}, {3, 4}, {1, 4}, {2, 3}, {1, 3}, {2, 4}};
        var obj = new CountCompleteComponents_2685_2();
        System.out.println(obj.countCompleteComponents(n, edges));
    }
}