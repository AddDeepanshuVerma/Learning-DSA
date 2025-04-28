package Random;

import java.util.Arrays;

class MinOperations_1827 {
    public static void main(String[] args) {

    }
    public int minOperations(int[] nums) {
        if(nums.length < 2) return 0;
        int sum = 0;
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                sum += nums[i-1] - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return sum;
    }

    public int minOperations1(int[] nums) {
        if(nums.length < 2) return 0;
        int sum = 0;
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                temp = nums[i];
                nums[i] = nums[i - 1] + 1;
                sum += nums[i] - temp;
            }
        }
        return sum;
    }
}