package _20_DynamicProgramming._1_01_KnapSack.Types;

public class _31_CountSubsetSum_recursion {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 5};
        System.out.println(findWays(nums, 5));
        int[] nums2 = {1, 0};
        System.out.println(findWays(nums2, 1));
        int[] nums3 = {12, 14, 3, 18, 2};
        System.out.println(findWays(nums3, 13));
    }

    public static int findWays(int[] nums, int k) {
        int countOfZeros = 0;
        for (int num : nums) if (num == 0) countOfZeros++;
        int ans = dfs(0, 0, k, nums);
        return countOfZeros > 0 ? ans * countOfZeros << 1 : ans;
    }
    
    // does not work, wrong approach when zeros are there.
    private static int dfs(int index, int currSum, int target, int[] nums) {
        if (currSum == target) {
            return 1;
        }
        if (index == nums.length || currSum > target) {
            return 0;
        }

        int exclude = dfs(index + 1, currSum, target, nums);
        int include = dfs(index + 1, currSum + nums[index], target, nums);

        return exclude + include;
    }
}