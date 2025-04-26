package POTD_LEETCODE;

class CountSubarrays_2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (max > maxK || min < minK) break;
                if (min == minK && max == maxK) {
                    count++;
                }
            }
        }
        return count;
    }
}