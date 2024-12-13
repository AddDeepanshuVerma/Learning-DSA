package POTD_LEETCODE.Array;

import jdk.jfr.Description;

class IsArraySpecial_3152 {

    @Description("Time complexity is ~ n^2")
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];

            res[i] = calculate(nums, first, second);
        }
        return res;
    }

    private boolean calculate(int[] nums, int i, int j) {
        for (int k = i; k <= j - 1; k++) {
            if (((nums[k] & 1) ^ (nums[k + 1] & 1)) == 0) {
                return false;
            }
        }
        return true;
    }

    //======================== Optimized sol ============================

    @Description("We will use the prefix sum here; Time complexity is ~ n")
    public boolean[] isArraySpecial2(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n];
        boolean[] ans = new boolean[queries.length];

        for (int i = 1; i < n; i++) {
            if ((nums[i] & 1) == (nums[i - 1] & 1)) {
                prefix[i] = prefix[i - 1] + 1;
            } else prefix[i] = prefix[i - 1];
        }

        for (int i = 0; i < ans.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            if (prefix[first] == prefix[second]) {
                ans[i] = true;
            }
        }
        return ans;
    }
}