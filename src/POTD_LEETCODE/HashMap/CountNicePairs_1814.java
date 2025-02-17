package POTD_LEETCODE.HashMap;

import java.util.HashMap;

class CountNicePairs_1814 {
    public static void main(String[] args) {
        var obj = new CountNicePairs_1814();
        int[] nums = {42, 11, 1, 97};
        System.out.println(obj.countNicePairs(nums));
    }

    public int countNicePairs(int[] nums) {
        int n = nums.length, count = 0, mod = 1000_000_007;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int res = nums[i] - reverse(nums[i]);
            count = (count + map.getOrDefault(res, 0)) % mod;
            map.merge(res, 1, Integer::sum);
        }
        return count;
    }

    private int reverse(int num) {
        int res = 0;
        while (num > 0) {
            res = (res * 10) + num % 10;
            num /= 10;
        }
        return res;
    }

    private int rev(int num) {
        return Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
    }
}