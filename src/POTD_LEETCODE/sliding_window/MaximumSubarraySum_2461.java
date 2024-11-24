package POTD_LEETCODE.sliding_window;

import java.util.HashSet;
import java.util.Set;

class MaximumSubarraySum_2461 {
    public static void main(String[] args) {
        int[] nums = {9, 18, 10, 13, 17, 9, 19, 2, 1, 18};
        System.out.println(maximumSubarraySum(nums, 5));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        long ans = 0, sum = 0;
        for (int j = 0; j < nums.length; j++) {

            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];
            if (j - i + 1 == k) {
                ans = Math.max(ans, sum);
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return ans;
    }
}