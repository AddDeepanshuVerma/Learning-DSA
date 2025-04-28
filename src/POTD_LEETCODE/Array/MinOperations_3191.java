package POTD_LEETCODE.Array;

class MinOperations_3191 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int i = 0, count = 0;
        for (i = 0; i <= n - 3; i++) {
            if (nums[i] == 1) continue;
            count++;
            nums[i] = 1 - nums[i];
            nums[i + 1] = 1 - nums[i + 1];
            nums[i + 2] = 1 - nums[i + 2];
        }

        while (i < n) {
            if (nums[i++] == 0) {
                return -1;
            }
        }
        return count;
    }
}