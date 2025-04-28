package _20_DynamicProgramming._1_01_KnapSack.Types;

import java.util.Arrays;

class _12_SubsetSum_memoization {
    public static void main(String[] args) {
        int[] nums = {29, 66, 31, 2, 28, 88, 1, 97, 73, 78, 62, 27, 97, 73, 78, 62, 27, 97, 73, 78, 62, 27, 97, 73, 78, 62, 27};
        System.out.println(isSubsetSum(nums, 582));

    }

    // though memoization does not work here as expected, reason being : ASAP we got the answer we simply return
    // & does not check any further possibility, hence memo is not needed is most of the part.
    static int[][] dp;

    static Boolean isSubsetSum(int arr[], int target) {
        int index = 0, currSum = 0;
        dp = new int[arr.length + 1][target + 1];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return dfs(index, arr, currSum, target);
    }

    private static Boolean dfs(int index, int[] arr, int currSum, int targetSum) {
        if (currSum == targetSum) return true;
        if (index == arr.length || currSum > targetSum) {
            return false;
        }

        if (dp[index][currSum] != -1) {
            System.out.println("Ran memo");
            return dp[index][currSum] == 1;
        }

        boolean res = dfs(index + 1, arr, currSum + arr[index], targetSum) || dfs(index + 1, arr, currSum, targetSum);
        dp[index][currSum] = res ? 1 : 0;

        return dp[index][currSum] == 1;
    }

}