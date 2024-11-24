package POTD_LEETCODE.SubArray;

import java.util.Arrays;
import java.util.HashMap;

class MinSubarray_1590 {
    public static void main(String[] args) {
        int[] nums = {26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3};
        int ans = MinSubarray_1590.minSubarray(nums, 26);
        System.out.println("ans = " + ans);
    }

    public static int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int rem = (int) (sum % p);
        if (rem == 0) return 0;

        int prefixSum = 0, length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int find = prefixSum % rem;
            if (map.containsKey(find)) {
//                length = Math.min(length, i - map.get(find));
                int temp = i - map.get(find);
                if(length > temp) {
                    length = temp;
                    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, map.get(find) + 1, i + 1)));
                }
            }
            map.put(find, i);
        }

        return length == nums.length ? -1 : length;
    }
}