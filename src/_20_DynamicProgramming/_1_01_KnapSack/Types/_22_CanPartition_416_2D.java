package _20_DynamicProgramming._1_01_KnapSack.Types;

import java.util.Arrays;

class _22_CanPartition_416_2D {
    public static void main(String[] args) {
        int[] nums = {6, 1, 2};
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        return subSetSum(nums, sum >> 1);
    }

    private boolean subSetSum(int[] nums, int target) {
        boolean[][] t = new boolean[nums.length][target + 1];

        // base case
        t[0][0] = true;
        for (int sum = 1; sum < target + 1; sum++) {
            if (sum == nums[0]) t[0][sum] = true;
        }

        for (int i = 1; i < t.length; i++) {
            for (int sum = 0; sum < target + 1; sum++) {
                boolean exclude = t[i - 1][sum];

                boolean include = false;
                if (nums[i] <= sum) include = t[i - 1][sum - nums[i]];

                t[i][sum] = exclude || include;
            }
        }
        return t[nums.length - 1][target];
    }
}