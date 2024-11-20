package POTD_LEETCODE.SubSequence;

import java.util.Arrays;

class LengthOfLIS_2407 {
    public int lengthOfLIS(int[] nums, int k) {
        // Same description as : src/DailyCodeChallenge/SubSequence/LengthOfLIS_300_BottomUP.java

        int n = nums.length;
        int[] arr = new int[n];

        Arrays.fill(arr, 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && nums[i] - nums[j] <= k) {
                    arr[i] = Math.max(arr[i], 1 + arr[j]);
                    ans = Math.max(ans, arr[i]);
                }
            }
        }
        return ans;
    }
}