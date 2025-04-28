package Contest.Weekly_Contest._447;

public class Q2 {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i];
                int second = nums[j];
                if (Math.abs(first - second) <= maxDiff) {
                    parent[find(i)] = find(j);
                } else break;
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

    int[] parent;

    int find(int i) {
        if (i == parent[i]) return i;

        return parent[i] = find(parent[i]);
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();

    }
}
