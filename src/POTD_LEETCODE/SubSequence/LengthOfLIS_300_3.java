package POTD_LEETCODE.SubSequence;

import java.util.Arrays;

class LengthOfLIS_300_3 {
    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        int currIndex = 0, previousIndex = -1;

        dp = new int[nums.length][nums.length];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return dfs(currIndex, previousIndex, nums);
    }

    private int dfs(int index, int prevIndex, int[] nums) {
        if (index == nums.length) return 0;

        if (prevIndex != -1 && dp[index][prevIndex] != -1) return dp[index][prevIndex];

        int skip = dfs(index + 1, prevIndex, nums);
        if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
            skip = Math.max(skip, 1 + dfs(index + 1, index, nums)); // Math.max(skip, take );
        }

        return prevIndex != -1 ? dp[index][prevIndex] = skip : skip;
    }

}