package _17_SlidingWindow.hard;

import java.util.HashMap;

class SubarraysWithKDistinct_992 {
    /*
     * When the subarray wants :
     *   ATMOST k amount of that : while(currAmount > k) keep shrinking window from left & now (currAmount <= k) then ans += j - i + 1;
     *  ATLEAST k amount of that : When we hit while(currAmount == k) then ans += arr.length - j; & shrink window from left
     *  EXACTLY k amount of that : (count of subarrays with ATMOST k amount of that) - (count of subarrays with ATMOST k - 1 amount of that)
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    // find subArray where distinct integer is atmost max
    private int count(int[] nums, int max) {
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (map.merge(nums[j], 1, Integer::sum) == 1) {
                count++;
            }
            while (count > max) {
                if (map.merge(nums[i], -1, Integer::sum) == 0) {
                    count--;
                }
                i++;
            }

            ans += j - i + 1;
        }
        return ans;
    }
}