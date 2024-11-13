package _20_DynamicProgramming._1_01_KnapSack.Types;

import java.util.Arrays;

public class _32_CountSubsetSum_memoization {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 4, 5};
//        int[] nums2 = {12, 14, 3, 18, 2};
//        System.out.println(findWays(nums2, 13));

        int[] nums = {1, 0};
        System.out.println(findWays(nums, 1));
    }

    static int[][] dp;

    // does not work, wrong approach when zeros are there.
    public static int findWays(int[] nums, int k) {
        dp = new int[nums.length + 1][k + 1];
        for (int[] ints : dp) Arrays.fill(ints, -1);

        int countOfZeros = 0;
        for (int num : nums) if (num == 0) countOfZeros++;
        int ans = dfs(0, 0, k, nums);

        return countOfZeros > 0 ? ans * countOfZeros << 1 : ans;
    }

    private static int dfs(int index, int currSum, int target, int[] nums) {
        if (currSum == target) return 1;
        if (index == nums.length || currSum > target) return 0;
        if (dp[index][currSum] != -1) return dp[index][currSum];

        int exclude = dfs(index + 1, currSum, target, nums);
        int include = dfs(index + 1, currSum + nums[index], target, nums);

        return dp[index][currSum] = exclude + include;
    }
}