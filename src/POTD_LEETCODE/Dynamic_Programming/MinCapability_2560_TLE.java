package POTD_LEETCODE.Dynamic_Programming;

import java.util.Arrays;

class MinCapability_2560_TLE {
    public static void main(String[] args) {
        var obj = new MinCapability_2560_TLE();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(obj.minCapabilityDP(nums, 2));
    }

    // DP : GOT TLE as maxInput was 10^5
    public int minCapabilityDP(int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][k + 1];
        for (int[] ints : dp) Arrays.fill(ints, -1);

        return solve(0, k, nums, dp);
    }

    private int solve(int i, int k, int[] nums, int[][] dp) {
        if (k == 0) return 0;
        if (i >= nums.length) return Integer.MAX_VALUE;

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int taken = Math.max(nums[i], solve(i + 2, k - 1, nums, dp));
        int notTaken = solve(i + 1, k, nums, dp);

        return dp[i][k] = Math.min(taken, notTaken);
    }
}
