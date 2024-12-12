package POTD_LEETCODE.Array;

class IsArraySpecial_3152 {
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
}