package _07_Sorting.Ques.Easy;

import java.util.Arrays;

class maxProduct_1464 {
    public static void main(String[] args) {
        int[] arr= {3,4,5,2};
        System.out.println(maxProduct2(arr));
    }

    private static int maxProduct2(int[] arr) {
        int maxer = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > maxer) {
                max = maxer;
                maxer = num;
            } else if (num > max) {
                max = num;
            }
        }
        return (maxer - 1) * (max - 1);
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}