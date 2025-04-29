package POTD_LEETCODE.sliding_window;

class CountSubarrays_2962 {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
                count = 1;
            } else if (num == max) {
                count++;
            }
        }
        if (count < k) return 0; // edge case

        int i = 0, tempCount = 0, n = nums.length;
        long ans = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == max) {
                tempCount++;
            }

            while (tempCount >= k) {
                ans += n - j;
                if (nums[i] == max) {
                    tempCount--;
                }
                i++;
            }

        }
        return ans;
    }
}