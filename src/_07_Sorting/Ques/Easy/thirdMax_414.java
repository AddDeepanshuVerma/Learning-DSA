package _07_Sorting.Ques.Easy;

import java.util.*;

class thirdMax_414 {
    public static void main(String[] args) {
        int[] nums = {1,2,-2147483648};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            long left = i == 0 ? Long.MIN_VALUE : nums[i - 1];
            if (nums[i] != left) {
                count++;
                if (count == 3) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];

    }
}