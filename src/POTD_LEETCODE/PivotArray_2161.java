package POTD_LEETCODE;

import java.util.ArrayList;

class PivotArray_2161 {
    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int[] ans = pivotArray2(nums, 10);
    }

    //O(3N)
    public static int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>(), equal = new ArrayList<>(), greater = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }
        int i = 0;
        for (int val : less) nums[i++] = val;
        for (int val : equal) nums[i++] = val;
        for (int val : greater) nums[i++] = val;
        return nums;
    }

    public static int[] pivotArray2(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int m = 0;
        for (int num : nums) if (num < pivot) ans[m++] = num;
        for (int num : nums) if (num == pivot) ans[m++] = num;
        for (int num : nums) if (num > pivot) ans[m++] = num;
        return ans;
    }

}