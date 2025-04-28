package POTD_LEETCODE.Two_Pointer;

import java.util.Arrays;

class CountFairPairs_2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return solve(nums, upper) - solve(nums, lower - 1);
    }

    private long solve(int[] nums, int max) {
        int start = 0, end = nums.length - 1;
        long ans = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum <= max) {
                ans += end - start;
                start++;
            } else {
                end--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var obj = new CountFairPairs_2563();
        int[] nums = {0, 1, 7, 4, 4, 5};

        long ans = obj.countFairPairs(nums, 3, 6);
        System.out.println("ans = " + ans);
    }
}