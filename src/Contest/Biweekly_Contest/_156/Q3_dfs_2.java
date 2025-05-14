package Contest.Biweekly_Contest._156;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Time Limit Exceeded 945 / 959 testcases passed
public class Q3_dfs_2 {

    private List<List<int[]>> adj;

    public int maxWeight(int n, int[][] edges, int k, int t) {
        // we will be applying DFS on each node and storing the maximum weight we can find
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dfs(i, 0, k, t);
            ans = Math.max(ans, temp);
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    // path == maxPath && curSum < totalSum
    private int dfs(int u, int currSum, int k, int t) {
        if (currSum >= t) { // total pathSum overtook to maxSum
            return Integer.MIN_VALUE;
        }
        if (k == 0) { // all steps consumed
            return currSum;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int[] ngbr : adj.get(u)) {
            int v = ngbr[0], w = ngbr[1];
            maxSum = Math.max(maxSum, dfs(v, currSum + w, k - 1, t));
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Q3_dfs_2 obj = new Q3_dfs_2();
        int n = 3, k = 2, t = 4;
        int[][] edges = {{0, 1, 1}, {1, 2, 2}};

        int ans = obj.maxWeight(n, edges, k, t);
        System.out.println("ans = " + ans);
    }
}
