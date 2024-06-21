package Sorting_07.Ques.Easy;

import java.util.Arrays;

class maximumProduct_628 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(maximumProduct2(nums));
    }

    private static int maximumProduct2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n - 1] * nums[0] * nums[1],
                        nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        int n = nums.length;
        if (nums[0] < 0 && nums[1] < 0) {
            if (nums[n - 1] > 0) {
                res = nums[0] * nums[1] * nums[n - 1];
            }else {
                res = nums[n - 1] * nums[n - 2] * nums[n - 3];
            }
        } else {
            for (int i = n - 1; i >= n - 3; i--) {
                res *= nums[i];
            }
        }
        return res;
    }
}