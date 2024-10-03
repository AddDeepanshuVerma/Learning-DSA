package DailyCodeChallenge.SubArray;

import java.util.Arrays;
import java.util.HashMap;

class MinSubarray_1590_final {
    public static void main(String[] args) {
        int[] nums = {26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3};
        int ans = MinSubarray_1590_final.minSubarray(nums, 26);
        System.out.println("ans = " + ans);
    }

    public static int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) sum += num;

        final int rem = (int) (sum % p);
        if (rem == 0) return 0;

        int prefix = 0, length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            prefix %= p;
            int target = (prefix - rem + p) % p;
            if (map.containsKey(target)) {
                length = Math.min(length, i - map.get(target));
            }
            map.put(prefix, i);
        }

        return length == nums.length ? -1 : length;
    }
}