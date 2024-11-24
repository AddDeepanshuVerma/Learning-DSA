package _20_DynamicProgramming._2_Unbounded_KnapSack.Algo;

import java.util.Arrays;

public class _1Dimensional_tab {
    public static void main(String[] args) {
//        int[] nums2 = {1, 3, 3, 2};
//        System.out.println(solve(nums2, 3));
        int[] nums1 = {1, 2, 3};
        System.out.println(solve(nums1, 5));
        // the number of subset whose sum would be equal to 4 are :
        // {1,1,1}, {1,1,2}, {3}, {3}
    }

    /*
    here unlike 0/1 knapSack we are not dependent on previous row instead we are focusing on previous row value of
    same column and same row value of some previous column
    hence we don't need to run reverse loop considering values will be changed new row instead we need new row,
    so we are iterating in left to right
    */
    public static int solve(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) { // changes are here
                if (j - nums[i] >= 0) dp[j] += dp[j - nums[i]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[sum];
    }
}
