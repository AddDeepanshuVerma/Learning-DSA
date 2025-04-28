package POTD_LEETCODE.Array;

import java.util.Arrays;

class ApplyOperations_2460 {
    public static void main(String[] args) {
        int[] nums = {847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272};
        applyOperations(nums);
    }

    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }

        System.out.println("nums = " + Arrays.toString(nums));
        int i = -1;
        int j = 0;
        while (j < n) {
            if (nums[j] == 0 && i == -1) {
                i = j;
            }
            if (nums[j] > 0 && i != -1 && nums[i] == 0) {
                swap(i, j, nums);
                i++;
            }
            j++;
        }
        System.out.println("nums = " + Arrays.toString(nums));
        return nums;
    }

    public static int[] applyOperations2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }

        int[] ans = new int[n];
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                ans[j] = num;
                j++;
            }
        }
        return ans;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}