package Contest.Biweekly_Contest._156;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Time Limit Exceeded 917 / 959 testcases passed
public class Q3_dfs {

    private HashMap<Integer, List<int[]>> adj;

    public int maxWeight(int n, int[][] edges, int k, int t) {
        // we will be applying DFS on each node and storing the maximum weight we can find
        adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[]{v, w});
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dfs(i, 0, 0, k, t);
            ans = Math.max(ans, temp);
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    // path == maxPath && curSum < totalSum
    private int dfs(int u, int currSum, int path, int maxPath, int totalSum) {
        if (currSum >= totalSum) {
            return Integer.MIN_VALUE;
        }
        if (path == maxPath) {
            return currSum;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int[] ngbr : adj.getOrDefault(u, Collections.emptyList())) {
            int v = ngbr[0], w = ngbr[1];
            maxSum = Math.max(maxSum, dfs(v, currSum + w, path + 1, maxPath, totalSum));
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Q3_dfs obj = new Q3_dfs();
        int n = 3, k = 2, t = 4;
        int[][] edges = {{0, 1, 1}, {1, 2, 2}};

        int ans = obj.maxWeight(n, edges, k, t);
        System.out.println("ans = " + ans);
    }
}
