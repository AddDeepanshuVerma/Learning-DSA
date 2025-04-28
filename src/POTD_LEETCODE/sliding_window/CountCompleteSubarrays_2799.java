package POTD_LEETCODE.sliding_window;

import java.util.HashMap;
import java.util.HashSet;

class CountCompleteSubarrays_2799 {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) unique.add(num);
        int UniqueCount = unique.size();

        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currCount = 0, ans = 0, n = nums.length;
        for (int j = 0; j < n; j++) {
            if (map.merge(nums[j], 1, Integer::sum) == 1) {
                currCount++;
            }

            while (currCount == UniqueCount) {
                ans += n - j;
                if (map.merge(nums[i], -1, Integer::sum) == 0) {
                    currCount--;
                }
                i++;
            }

        }

        return ans;
    }

}