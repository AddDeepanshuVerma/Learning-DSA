package POTD_LEETCODE.Level_1;

import java.util.Arrays;

class MinKBitFlips_995 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 0, 1, 1, 0, 0};
        int k = 3;
//        System.out.println(Arrays.toString(nums));
        System.out.println(minKBitFlips(nums, k));
        System.out.println(Arrays.toString(nums));
    }

    // Brute force approach, GOT TLE
    public static int minKBitFlips(int[] nums, int k) {
        int i;
        int count = 0;
        int n = nums.length;
        for (i = 0; i <= n - k; i++) {
            if (nums[i] == 0) {
                count++;
                flip(nums, i, k);
            }
        }
        for (int j = i; j < n; j++) {
            if (nums[j] == 0) {
                return -1;
            }
        }
        return count;
    }

    private static void flip(int[] nums, int i, int k) {
        for (int j = i; j < i + k; j++) {
            nums[j] = nums[j] == 1 ? 0 : 1;
        }
    }
}