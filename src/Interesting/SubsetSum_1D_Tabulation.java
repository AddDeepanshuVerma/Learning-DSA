package Interesting;

import java.util.Arrays;

class SubsetSum_1D_Tabulation {
    public static void main(String[] args) {
        int[] nums = {6, 1, 2};
        System.out.println(isSubsetSum(nums, 6));

    }

    // compact
    static Boolean isSubsetSum(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            System.out.println("dp = " + Arrays.toString(dp));
            for (int j = target; j >= num; j--) { // reverse iteration j !>= 0
                dp[j] = dp[j] || dp[j - num]; // either itself or current (target - current index num)
            }
        }
        return dp[target];
    }

}