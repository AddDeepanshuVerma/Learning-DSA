package _21_Graphs.Leetcode._3hard;

import java.util.Arrays;

class MinimumCost_3108_DSU_2 {
    private static final int MASK = (1 << 31) - 1;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        //DSU prerequisite
        parent = new int[n];
        and = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            and[i] = MASK;
        }
        // ALL THE EDGES has to be union
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int uParent = find(u), vParent = find(v);
            // union all the edges does not matter if they were part of same component or not as this new edge might be the reason for smallest answer
            parent[vParent] = uParent;
            and[uParent] = and[uParent] & and[vParent] & w;
        }

        // now we can work on queries
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int u = query[i][0], v = query[i][1];
            int uParent = find(u), vParent = find(v);
            ans[i] = uParent == vParent ? and[uParent] : -1;
        }
        return ans;
    }

    int[] parent;
    int[] and;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 2, 7}, {0, 1, 15}, {1, 2, 6}, {1, 2, 1}};
        int[][] query = {{1, 2}};

        var obj = new MinimumCost_3108_DSU_2();
        int[] ans = obj.minimumCost(n, edges, query);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}