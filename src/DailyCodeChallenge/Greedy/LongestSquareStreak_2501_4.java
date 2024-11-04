package DailyCodeChallenge.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LongestSquareStreak_2501_4 {
    public static void main(String[] args) {
        LongestSquareStreak_2501_4 obj = new LongestSquareStreak_2501_4();
        int[] nums = {92682, 18532};
        System.out.println(obj.longestSquareStreak(nums));
    }

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(nums[i], map.getOrDefault(nums[i] * nums[i], 0) + 1);
        }
        for (int i : map.values()) {
            cnt = Math.max(cnt, i);
        }
        return cnt == 1 ? -1 : cnt;
    }
}