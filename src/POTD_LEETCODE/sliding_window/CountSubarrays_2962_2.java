package POTD_LEETCODE.sliding_window;

class CountSubarrays_2962_2 {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long ans = 0;
        int n = nums.length;
        for (int i = 0, j = 0, count = 0; j < n; j++) {
            if (nums[j] == max) count++;
            while (count >= k) {
                ans += n - j;
                if (nums[i++] == max) count--;
            }
        }
        return ans;
    }
}