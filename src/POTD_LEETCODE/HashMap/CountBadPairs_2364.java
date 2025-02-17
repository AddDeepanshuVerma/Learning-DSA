package POTD_LEETCODE.HashMap;

import jdk.jfr.Description;

import java.util.HashMap;

class CountBadPairs_2364 {

    @Description("TLE")
    public long countBadPairs(int[] nums) {
        long count = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] != (j - i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public long countBadPairs2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long n = nums.length, count = n * (n - 1) >> 1;
        for (int i = 0; i < n; i++) {
            int curr = nums[i] - i;
            count -= map.getOrDefault(curr, 0);
            map.merge(curr, 1, Integer::sum);
        }
        return count;
    }
}