package POTD_LEETCODE.level_3;

import jdk.jfr.Description;

class LongestSubarray_2419 {
    public static void main(String[] args) {
        LongestSubarray_2419 obj = new LongestSubarray_2419();
        int[] nums = {1, 2, 3, 4};
        System.out.println(obj.longestSubarray(nums));
    }

    @Description("time complexity of O(n^2) not accepted")
    public int longestSubarray(int[] nums) {
        int max = 0, length = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = (1 << 31) - 1;
            for (int j = i; j < nums.length; j++) {
                temp = temp & nums[j];
                if (temp >= max) {
                    length = temp > max ? j - i + 1 : Math.max(length, j - i + 1);
                    max = temp;
                }
            }
        }
        return length;
    }

    public int longestSubarray2(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            if (num > max) max = num;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            while (i < nums.length && nums[i] == max) {
                temp++;
                i++;
                if (temp > count) count = temp;
            }
        }
        return count;
    }

    public int longestSubarray3(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            if (num > max) max = num;

        int maxLength = 0;
        int count = 0;
        for (int num : nums) {
            if (num == max) {
                count++;
                maxLength = Math.max(count, maxLength);
            } else count = 0;
        }
        return maxLength;
    }
}