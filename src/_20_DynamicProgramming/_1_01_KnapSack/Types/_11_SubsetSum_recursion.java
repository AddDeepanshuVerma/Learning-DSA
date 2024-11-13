package _20_DynamicProgramming._1_01_KnapSack.Types;

class _11_SubsetSum_recursion {
    public static void main(String[] args) {
        int[] nums = {29, 66, 31, 2, 28, 88, 1, 97, 73, 78, 62, 27};
        System.out.println(isSubsetSum(nums, 582));

    }

    static Boolean isSubsetSum(int arr[], int target) {
        int index = 0, currSum = 0;
        return dfs(index, arr, currSum, target);
    }

    private static Boolean dfs(int index, int[] arr, int currSum, int targetSum) {
        if (currSum == targetSum) return true;
        if (index == arr.length || currSum > targetSum) {
            return false;
        }

        return dfs(index + 1, arr, currSum + arr[index], targetSum) || dfs(index + 1, arr, currSum, targetSum);
    }
}