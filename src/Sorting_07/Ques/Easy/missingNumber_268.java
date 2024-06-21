package Sorting_07.Ques.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

class missingNumber_268 {

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 9, 7, 0, 1};
        int i = missingNumber(nums);
        System.out.println(i);
    }

    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
                i--;
            }
        }
        /*int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            } else {
                i++;
            }
        }*/
        System.out.println(Arrays.toString(nums));
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != j) {
                return j;
            }
            j++;
        }
        /*if all elements were at expected position and
        max element would be array of length of array then
        length only element would be missing.
        ex : [0,1]
        */
        return nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}