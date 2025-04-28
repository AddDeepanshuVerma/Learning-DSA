package POTD_LEETCODE.prefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CountInterestingSubarrays_2845 {
    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] arr = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            if (((nums.get(i) % modulo) + modulo) % modulo == k) {
                arr[i] = 1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];
            int required = (((prefix % modulo) - k) + modulo) % modulo;
            count += map.getOrDefault(required, 0);
            map.merge(prefix % modulo, 1, Integer::sum);
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(2, 2, 5));
        int modulo = 3;
        int k = 2;
        long count = countInterestingSubarrays(nums, modulo, k);
        System.out.println("count = " + count);
    }
}