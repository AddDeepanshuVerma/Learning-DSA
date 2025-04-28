package Contest.Weekly_Contest._447;

public class Q2_3 {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            // find the max index of nums where value is <= nums[i] + maxDiff
            int idx = bs(i, nums[i] + maxDiff, nums);
            for (int j = i + 1; j <= idx; j++) {
                parent[find(i)] = find(j);
            }
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (find(u) == find(v)) {
                ans[i] = true;
            }
        }
        return ans;
    }

    private int bs(int start, int max, int[] nums) {
        int end = nums.length - 1;
        int ans = end;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] <= max) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) return i;

        return parent[i] = find(parent[i]);
    }

    public static void main(String[] args) {
        Q2_3 obj = new Q2_3();

    }
}
