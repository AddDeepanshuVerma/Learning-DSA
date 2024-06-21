package Sorting_07.Ques.Medium;

import jdk.jfr.Description;

import java.util.Arrays;

class sortColors_75 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2,2,2,2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    // dp : good ques
    @Description("passed all testcases + optimal solution")
    public static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int curr = 0;
        while (curr <= high) {
            if (nums[curr] == 2) {
                swap(nums, curr, high);
                high--;
            } else if (nums[curr] == 0) {
                swap(nums, curr, low);
                curr++;
                low++;
            } else if (nums[curr] == 1) {
                curr++;
            }
        }
    }

    private static void swap(int[] nums, int e1, int e2) {
        int temp = nums[e1];
        nums[e1] = nums[e2];
        nums[e2] = temp;
    }
}