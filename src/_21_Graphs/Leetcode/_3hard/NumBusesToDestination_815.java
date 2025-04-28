package _21_Graphs.Leetcode._3hard;

class NumBusesToDestination_815 {
    int[] parent;

    int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b) {
        int bParent = find(b);
        int aParent = find(a);
        parent[bParent] = aParent;
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        int nv = Integer.MIN_VALUE;
        for (int[] route : routes) {
            for (int val : route) {
                nv = Math.max(nv, val);
            }
        }
        parent = new int[nv + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] route : routes) {
            int parent = route[0];
            for (int i = 1; i < route.length; i++) {
                union(parent, route[i]);
            }
        }
        System.out.println(find(source) == find(target) ? "possible" : " not possible");

        return 0;
    }

}