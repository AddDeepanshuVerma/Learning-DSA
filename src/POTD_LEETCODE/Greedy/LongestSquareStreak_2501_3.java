package POTD_LEETCODE.Greedy;

import java.util.Arrays;

class LongestSquareStreak_2501_3 {
    public static void main(String[] args) {
        LongestSquareStreak_2501_3 obj = new LongestSquareStreak_2501_3();
        int[] nums = {316, 99856};
        System.out.println("Math.sqrt(Integer.MAX_VALUE) = " + Math.sqrt(Integer.MAX_VALUE));
        System.out.println(obj.longestSquareStreak(nums));
    }

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = search(nums[i], nums);
            max = Math.max(max, count);
        }
        return max == 0 ? -1 : max + 1;
    }

    private int search(int num, int[] nums) {
        int count = 0;
        int limit = (int) Math.sqrt(100_000);

        while (true) {
            if (num > limit) break;

            int index = Arrays.binarySearch(nums, num * num);
            if (index < 0) break;

            count++;
            num = num * num;
        }
        return count;
    }


}