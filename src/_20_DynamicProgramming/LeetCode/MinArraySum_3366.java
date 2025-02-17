package _20_DynamicProgramming.LeetCode;

import java.util.Arrays;

// 3D DP disguised as Greedy
class MinArraySum_3366 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3};
        System.out.println(minArraySum(nums, 3, 2, 1));
    }
    // Greedy Approach would not work as we don't exactly where op1 with combination of op2 should be applied
    // public static int minArraySum2(int[] nums, int k, int op1, int op2) {
    //      Arrays.sort(nums);
    //      int index = 0;
    //      while (op2 > 0 && index < nums.length) {
    //          if (nums[index] >= k) {
    //              nums[index] -= k;
    //              op2--;
    //          }
    //          index++;
    //      }
    //      Arrays.sort(nums);
    //
    //      index = nums.length - 1;
    //      while (op1-- > 0) {
    //          nums[index] = (nums[index] + 1) >> 1;
    //          index--;
    //      }
    //
    //      int sum = 0;
    //      for (int num : nums) sum += num;
    //      return sum;
    //  }

    //===========================================================================================

    static int[][][] dp;

    // using Recursion + Memoization = DP
    public static int minArraySum(int[] nums, int k, int op1, int op2) {
        int index = 0;
//        dp = new int[101][101][101];
        dp = new int[nums.length + 1][op1 + 1][op2 + 1]; // for more optimal space complexity specific to question
        for (int[][] ints : dp)
            for (int[] anInt : ints)
                Arrays.fill(anInt, -1);

        return solve(nums, index, op1, op2, k);
    }

    private static int solve(int[] nums, int index, int op1, int op2, int k) {
        if (index == nums.length) return 0;

        // base case
        if (dp[index][op1][op2] != -1) return dp[index][op1][op2];

        // case 1 :  no operation applied on current index
        int ans = nums[index] + solve(nums, index + 1, op1, op2, k);

        // case 2 : only op1 applied on current index
        if (op1 != 0) {
            int case2 = ((nums[index] + 1) >> 1) + solve(nums, index + 1, op1 - 1, op2, k);
            ans = Math.min(ans, case2);
        }

        // case 3 : only op1 applied on current index
        if (op2 != 0 && nums[index] >= k) {
            int case3 = (nums[index] - k) + solve(nums, index + 1, op1, op2 - 1, k);
            ans = Math.min(ans, case3);
        }

        // case 4 : apply op1 then op2 on current index
        if (op1 != 0 && op2 != 0 && ((nums[index] + 1) >> 1) >= k) {
            int case4 = (((nums[index] + 1) >> 1) - k) + solve(nums, index + 1, op1 - 1, op2 - 1, k);
            ans = Math.min(ans, case4);
        }

        // case 5 : apply op2 then op1 on current index
        if (op1 != 0 && op2 != 0 && nums[index] >= k) {
            int case5 = ((nums[index] - k + 1) >> 1) + solve(nums, index + 1, op1 - 1, op2 - 1, k);
            ans = Math.min(ans, case5);
        }

        return dp[index][op1][op2] = ans;
    }
}