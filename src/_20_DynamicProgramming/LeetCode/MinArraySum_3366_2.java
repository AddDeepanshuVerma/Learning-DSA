package _20_DynamicProgramming.LeetCode;

import java.util.Arrays;

// 3D DP disguised as Greedy
class MinArraySum_3366_2 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3};
        System.out.println(minArraySum(nums, 3, 2, 1));
    }

    static int[][][] dp;

    // using Recursion + Memoization = DP
    public static int minArraySum(int[] nums, int k, int op1, int op2) {
        int index = 0;
        dp = new int[nums.length + 1][op1 + 1][op2 + 1];
        for (int[][] ints : dp)
            for (int[] anInt : ints)
                Arrays.fill(anInt, -1);

        return solve(nums, index, op1, op2, k);
    }

    private static int solve(int[] nums, int index, int op1, int op2, int k) {
        if (index == nums.length) return 0;

        if (dp[index][op1][op2] != -1) return dp[index][op1][op2];

        int ans = nums[index] + solve(nums, index + 1, op1, op2, k);

        if (op1 != 0) {
            int case2 = ((nums[index] + 1) >> 1) + solve(nums, index + 1, op1 - 1, op2, k);
            ans = Math.min(ans, case2);
        }

        if (op2 != 0 && nums[index] >= k) {
            int case3 = (nums[index] - k) + solve(nums, index + 1, op1, op2 - 1, k);
            ans = Math.min(ans, case3);
        }

        if (op1 != 0 && op2 != 0 && ((nums[index] + 1) >> 1) >= k) {
            int case4 = (((nums[index] + 1) >> 1) - k) + solve(nums, index + 1, op1 - 1, op2 - 1, k);
            ans = Math.min(ans, case4);
        }

        if (op1 != 0 && op2 != 0 && nums[index] >= k) {
            int case5 = ((nums[index] - k + 1) >> 1) + solve(nums, index + 1, op1 - 1, op2 - 1, k);
            ans = Math.min(ans, case5);
        }

        return dp[index][op1][op2] = ans;
    }
}