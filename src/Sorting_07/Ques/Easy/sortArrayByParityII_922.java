package Sorting_07.Ques.Easy;

import java.util.Arrays;

class sortArrayByParityII_922 {
    public static void main(String[] args) {
        int[] arr = {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(arr)));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < n - 1 && j > 0) {
            if (nums[i] % 2 == 0) {
                i += 2;
            } else if (nums[j] % 2 != 0) {
                j -= 2;
            } else {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}