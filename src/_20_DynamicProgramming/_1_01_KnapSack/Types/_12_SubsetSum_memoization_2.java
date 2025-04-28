package _20_DynamicProgramming._1_01_KnapSack.Types;

class _12_SubsetSum_memoization_2 {
    public static void main(String[] args) {
        int[] nums = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100,97};
        System.out.println(isSubsetSum(nums, 897));

    }

    // though memoization does not work here as expected, reason being : ASAP we got the answer we simply return
    // & does not check any further possibility, hence memo is not needed is most of the part.
    static Boolean[][] dp;

    static Boolean isSubsetSum(int arr[], int target) {
        int index = 0, currSum = 0;
        dp = new Boolean[arr.length + 1][target + 1];
        return dfs(index, arr, currSum, target);
    }

    private static Boolean dfs(int index, int[] arr, int currSum, int targetSum) {
        if (currSum == targetSum) return true;
        if (index == arr.length || currSum > targetSum) {
            return false;
        }

        if (dp[index][currSum] != null) {
            System.out.println("ran memo");
            return dp[index][currSum];
        }

        return dp[index][currSum] = dfs(index + 1, arr, currSum + arr[index], targetSum) || dfs(index + 1, arr, currSum, targetSum);
    }

}