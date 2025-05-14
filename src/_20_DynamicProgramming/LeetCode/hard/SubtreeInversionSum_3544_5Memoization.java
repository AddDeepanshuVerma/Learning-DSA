package _20_DynamicProgramming.LeetCode.hard;

import java.util.ArrayList;
import java.util.List;

// Here we were lacking with single test case hence we used LinkList instead of HashMap to create graph & almost passed all test cases
// TLE : all testcases passed
class SubtreeInversionSum_3544_5Memoization {
    public long subtreeInversionSum(int[][] edges, int[] nums, int k) {
        int nv = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nv; i++) adj.add(new ArrayList<Integer>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int parent = -1, lca = k, sign = 1, currNode = 0;
        Long[][][] dp = new Long[nv + 1][k + 1][2];
        return dfs(currNode, lca, sign, parent, k, adj, nums, dp);
    }

    private long dfs(int u, int lca, int sign, int parent, int k, List<List<Integer>> adj , int[] nums, Long[][][] dp) {
        lca = Math.min(lca, k);
        if (dp[u][lca][(sign + 1) >> 1] != null) return dp[u][lca][(sign + 1) >> 1];

        long notInvert = (long) sign * nums[u];
        for (Integer v : adj.get(u)) {
            if (v == parent) continue;
            notInvert += dfs(v, lca + 1, sign, u, k, adj, nums, dp);
        }

        if (lca >= k) {
            long invert = (long) -sign * nums[u];
            for (Integer v : adj.get(u)) {
                if (v == parent) continue;
                invert += dfs(v, 1, -sign, u, k, adj, nums, dp);
            }
            notInvert = Math.max(notInvert, invert);
        }

        return dp[u][lca][(sign + 1) >> 1] = notInvert;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] nums = {4, -8, -6, 3, 7, -2, 5};
        int k = 2;
        var obj = new SubtreeInversionSum_3544_5Memoization();
        long ans = obj.subtreeInversionSum(edges, nums, k);
        System.out.println("ans = " + ans);
    }
}