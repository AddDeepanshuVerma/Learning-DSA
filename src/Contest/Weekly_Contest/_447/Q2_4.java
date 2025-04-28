package Contest.Weekly_Contest._447;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_4 {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                temp.add(i);
            } else {
                unionList(temp);
                temp = new ArrayList<>();
                temp.add(i);
            }
        }
        unionList(temp);

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

    private void unionList(List<Integer> temp) {
        if (temp.isEmpty()) return;
        int u = temp.get(0);
        for (Integer v : temp) {
            int uParent = parent[u];
            int vParent = parent[v];
            parent[vParent] = uParent;
        }
    }

    int[] parent;

    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]);
    }

    public static void main(String[] args) {
        Q2_4 obj = new Q2_4();
        int n = 4;
        int[] nums = {22867, 73815, 78888, 87890};
        int maxDiff = 71687;
        int[][] queries = {{1, 2}};

        boolean[] ans = obj.pathExistenceQueries(n, nums, maxDiff, queries);
        System.out.println("ans = " + Arrays.toString(ans));
    }
}
