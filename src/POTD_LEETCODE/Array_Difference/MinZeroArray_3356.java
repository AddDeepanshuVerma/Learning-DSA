package POTD_LEETCODE.Array_Difference;

class MinZeroArray_3356 {
    public static void main(String[] args) {
        int[] nums = {7, 6, 8};
        int[][] queries = {{0, 0, 2}, {0, 1, 5}, {2, 2, 5}, {0, 2, 4}};
        System.out.println(minZeroArray(nums, queries));
    }

    //n^2
    public static int minZeroArray(int[] nums, int[][] queries) {
        int countNonZero = 0;
        for (int num : nums) {
            if (num > 0) countNonZero++;
        }
        if (countNonZero == 0) return 0;

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1], d = queries[i][2];

            for (int k = l; k <= r; k++) {
                if (nums[k] == 0) continue;
                else if (nums[k] > d) nums[k] -= d;
                else {
                    nums[k] = 0;
                    countNonZero--;
                }
            }
            if (countNonZero == 0) return i + 1;
        }
        return -1;

    }
}