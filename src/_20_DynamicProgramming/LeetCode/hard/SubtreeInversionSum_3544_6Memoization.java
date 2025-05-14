package _20_DynamicProgramming.LeetCode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TLE : all test cases passed, tweaking the same solution a bit
class SubtreeInversionSum_3544_6Memoization {
    public long subtreeInversionSum(int[][] edges, int[] nums, int k) {
        int nv = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nv; i++) adj.add(new ArrayList<Integer>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int parent = -1, lca = k, sign = 1, currNode = 0;
        long[][][] dp = new long[nv + 1][k + 1][2];
        for (long[][] arr2D : dp) for (long[] arr : arr2D) Arrays.fill(arr, Long.MIN_VALUE);

        return dfs(currNode, lca, sign, parent, k, adj, nums, dp);
    }

    private long dfs(int u, int lca, int sign, int parent, int k, List<List<Integer>> adj, int[] nums, long[][][] dp) {
        if (dp[u][lca][(sign + 1) >> 1] != Long.MIN_VALUE) return dp[u][lca][(sign + 1) >> 1];

        long notInvert = (long) sign * nums[u];
        for (Integer v : adj.get(u)) {
            if (v == parent) continue;
            notInvert += dfs(v, Math.min(lca + 1, k), sign, u, k, adj, nums, dp);
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
        var obj = new SubtreeInversionSum_3544_6Memoization();
        long ans = obj.subtreeInversionSum(edges, nums, k);
        System.out.println("ans = " + ans);
    }
}