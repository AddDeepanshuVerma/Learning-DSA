package _20_DynamicProgramming.LeetCode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// TLE : 663 / 676 testcases passed
class SubtreeInversionSum_3544_2Recursion {
    public long subtreeInversionSum(int[][] edges, int[] nums, int k) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, list -> new ArrayList<>()).add(u);
        }

        int parent = -1, lca = k, sign = 1, currNode = 0;
        return dfs(currNode, lca, sign, parent, k, adj, nums);
    }

    private long dfs(int u, int lca, int sign, int parent, int k, HashMap<Integer, List<Integer>> adj, int[] nums) {
        long notInvert = (long) sign * nums[u];
        for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
            if (v == parent) continue;
            notInvert += dfs(v, lca + 1, sign, u, k, adj, nums);
        }

        if (lca >= k) {
            long invert = (long) -sign * nums[u];
            for (Integer v : adj.getOrDefault(u, Collections.emptyList())) {
                if (v == parent) continue;
                invert += dfs(v, 1, -sign, u, k, adj, nums);
            }
            notInvert = Math.max(notInvert, invert);
        }

        return notInvert;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] nums = {4, -8, -6, 3, 7, -2, 5};
        int k = 2;
        var obj = new SubtreeInversionSum_3544_2Recursion();
        long ans = obj.subtreeInversionSum(edges, nums, k);
        System.out.println("ans = " + ans);
    }
}