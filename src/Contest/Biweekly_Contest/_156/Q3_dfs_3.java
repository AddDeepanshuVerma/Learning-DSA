package Contest.Biweekly_Contest._156;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Time Limit Exceeded 958 / 959 testcases passed
public class Q3_dfs_3 {

    private Integer[][][] dp;

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
        dp = new Integer[n][t][k + 1];
        for (int i = 0; i < n; i++) {
            int val = dfs(i, 0, 0, adj, k, t);
            ans = Math.max(ans, val);
        }

        return ans;
    }

    // path == maxPath && curSum < totalSum
    private int dfs(int u, int sum, int count, List<List<int[]>> adj, int k, int t) {
        if (sum >= t || count > k) return -1;
        if (count == k) return dp[u][sum][count] = sum;

        if (dp[u][sum][count] != null) {
            return dp[u][sum][count];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int[] ngbr : adj.get(u)) {
            int v = ngbr[0], w = ngbr[1];
            maxSum = Math.max(maxSum, dfs(v, sum + w, count + 1, adj, k, t));
        }

        return dp[u][sum][count] = maxSum;
    }

    public static void main(String[] args) {
        Q3_dfs_3 obj = new Q3_dfs_3();
        int n = 3, k = 2, t = 4;
        int[][] edges = {{0, 1, 1}, {1, 2, 2}};

        int ans = obj.maxWeight(n, edges, k, t);
        System.out.println("ans = " + ans);
    }
}
