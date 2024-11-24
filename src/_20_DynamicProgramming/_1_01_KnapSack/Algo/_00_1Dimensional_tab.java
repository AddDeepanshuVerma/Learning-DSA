package _20_DynamicProgramming._1_01_KnapSack.Algo;

import java.util.Arrays;

public class _00_1Dimensional_tab {
    public static void main(String[] args) {
        int[] nums2 = {1, 0};
        System.out.println(solve(nums2, 1));
    }


    public static int solve(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) dp[j] += dp[j - nums[i]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[sum];
    }
}
