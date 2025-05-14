package Contest.Biweekly_Contest._156;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Barely passes ALL test cases
class Q3_dfs_4 {

    private int[][][] dp;

    public int maxWeight(int n, int[][] edges, int k, int t) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        int ans = -1;
        dp = new int[n][k + 1][t];
        for (int[][] arr2 : dp) {
            for (int[] arr1 : arr2) {
                Arrays.fill(arr1, -2);   // -2 = not visited, -1 = invalid, otherwise max sum
            }
        }

        for (int i = 0; i < n; i++) {
            int val = dfs(i, 0, 0, adj, k, t);
            ans = Math.max(ans, val);
        }

        return ans;
    }

    // path == maxPath && curSum < totalSum
    private int dfs(int u, int count, int sum, List<List<int[]>> adj, int k, int t) {
        if (sum >= t || count > k) return -1;

        if (dp[u][count][sum] != -2) return dp[u][count][sum];

        if (count == k) return dp[u][count][sum] = sum;

        int maxSum = -1;
        for (int[] ngbr : adj.get(u)) {
            int v = ngbr[0], w = ngbr[1];
            maxSum = Math.max(maxSum, dfs(v, count + 1, sum + w, adj, k, t));
        }

        return dp[u][count][sum] = maxSum;
    }
}