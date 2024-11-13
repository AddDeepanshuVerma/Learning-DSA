package _20_DynamicProgramming._1_01_KnapSack.Types;

class _61_TargetSum_tab_1D_3 {
    public static void main(String[] args) {
        int[] arr = {1000};
        System.out.println(findTargetSumWays(arr, -1000));

    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < target || (target + sum) % 2 > 0 ? 0 : subsetSum(nums, (target + sum) >>> 1);
    }

    public static int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
}