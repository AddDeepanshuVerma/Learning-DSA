package Sorting_07.Ques.Easy;

import java.util.Arrays;

class largestPerimeter_976 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 3};
        System.out.println(largestPerimeter2(arr));
    }

    private static int largestPerimeter2(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; i--) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];
            if (a + b > c)
                return a + b + c;
        }
        return 0;
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int diff = 0;
        int add = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            diff = nums[i] - nums[i - 1];
            add = nums[i] + nums[i - 1];
            for (int j = i - 2; j >= 0; j--) {
                if (nums[j] > diff && nums[j] < add) {
                    return add + nums[j];
                }
            }

        }
        return 0;
    }
}