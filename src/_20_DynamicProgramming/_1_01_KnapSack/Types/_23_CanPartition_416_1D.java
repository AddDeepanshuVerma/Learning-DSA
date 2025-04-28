package _20_DynamicProgramming._1_01_KnapSack.Types;

import java.util.Arrays;

class _23_CanPartition_416_1D {
    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 3};
        System.out.println(new _23_CanPartition_416_1D().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        return subSetSum(nums, sum >> 1);
    }

    private boolean subSetSum(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) { // reverse iteration j !>= 0
                dp[j] = dp[j] || dp[j - num]; // either itself or current (target - current index num)
            }
        }
        return dp[target];
    }
}