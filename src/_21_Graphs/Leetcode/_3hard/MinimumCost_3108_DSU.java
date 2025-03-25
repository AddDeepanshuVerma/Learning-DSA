package _21_Graphs.Leetcode._3hard;

import java.util.Arrays;

class MinimumCost_3108_DSU {
    private static final int MASK = (1 << 31) - 1;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        //DSU prerequisite
        parent = new int[n];
        and = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            and[i] = MASK;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int uParent = find(u);
            int vParent = find(v);
            union(u, v, w);
        }
        // now we can work on queries
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int u = query[i][0], v = query[i][1];
            int uParent = find(u), vParent = find(v);
            if (uParent != vParent) { //if they do not belong to same component then -1
                ans[i] = -1;
                continue;
            }
            // now they do belong to same component hence that components overall & of all the edge's weight would be the answer
            ans[i] = and[uParent];
        }

        return ans;
    }

    int[] parent;
    int[] and;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int a, int b, int w) {
        int aParent = find(a);
        int bParent = find(b);
        parent[bParent] = aParent;
        and[aParent] = and[aParent] & and[bParent]; // first we will collide both the components
        and[aParent] = and[aParent] & w;            // then will use curr edge weight to find the minimum one
    }

    public static void main(String[] args) {
        var obj = new MinimumCost_3108_DSU();
//        int n = 5;
//        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
//        int[][] query = {{0, 3}, {3, 4}};

        int n = 3;
        int[][] edges = {{0, 2, 7}, {0, 1, 15}, {1, 2, 6}, {1, 2, 1}};
        int[][] query = {{1, 2}};

        int[] ans = obj.minimumCost(n, edges, query);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}