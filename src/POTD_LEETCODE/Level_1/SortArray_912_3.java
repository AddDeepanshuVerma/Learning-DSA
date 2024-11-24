package POTD_LEETCODE.Level_1;

import java.util.Arrays;

class SortArray_912_3 {
    public static void main(String[] args) {
        int[] nums = {5, 9, 8, 7, 6};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] sortArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int n = max - min;
        int[] arr = new int[n + 1];

        for (int num : nums) {
            arr[num - min]++;
        }
        int index = 0;
        for (int i = 0; i <= n; i++) {
            while (arr[i] > 0) {
                nums[index] = min;
                index++;
                arr[i]--;
            }

            min++;
        }

        return nums;
    }
}
