package POTD_LEETCODE.Array;

import java.util.HashMap;

class CountKDifference_2006 {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countKDifference2(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int first = nums[i] - k;
            int second = k + nums[i];
            count += map.getOrDefault(first, 0) + map.getOrDefault(second, 0);
            map.merge(nums[i], 1, Integer::sum);
        }
        return count;
    }
}