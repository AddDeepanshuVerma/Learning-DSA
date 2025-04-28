package _20_DynamicProgramming._1_01_KnapSack.Types;

import java.util.Arrays;

class _21_canPartition_memoization {
    public static void main(String[] args) {
        int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97};
        System.out.println(canPartition(nums));

    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        return isSubsetSum(nums, sum >> 1);
    }

    static Boolean[][] dp;
    static int memoRan = 0;

    static Boolean isSubsetSum(int arr[], int target) {
        int index = 0, currSum = 0;
        dp = new Boolean[arr.length + 1][target + 1];
        Boolean dfs = dfs(index, arr, currSum, target);
        System.out.println("memoRan = " + memoRan);
        return dfs;
    }

    private static Boolean dfs(int index, int[] arr, int currSum, int targetSum) {
        if (currSum == targetSum) return true;
        if (index == arr.length || currSum > targetSum) {
            return false;
        }

        if (dp[index][currSum] != null) {
            memoRan++;
            return dp[index][currSum];
        }

        return dp[index][currSum] = dfs(index + 1, arr, currSum + arr[index], targetSum) || dfs(index + 1, arr, currSum, targetSum);
    }

}