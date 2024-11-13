package _20_DynamicProgramming._1_01_KnapSack.Types;

public class _35_CountSubsetSum_tab_1D_2 {
    public static void main(String[] args) {
        int[] nums2 = {1, 0};
        System.out.println(findWays(nums2, 1));
    }

    public static int findWays(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}