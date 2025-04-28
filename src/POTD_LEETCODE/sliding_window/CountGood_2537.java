package POTD_LEETCODE.sliding_window;

import java.util.HashMap;

// n^2 :: TLE
class CountGood_2537 {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, n = nums.length;
        long count = 0;
        for (int j = 0; j < n; j++) {
            map.merge(nums[j], 1, Integer::sum);
            while (isValidPair(map, k)) {
                count += n - j;
                map.merge(nums[i], -1, Integer::sum);
                i++;
            }
        }

        return count;
    }

    private boolean isValidPair(HashMap<Integer, Integer> map, int k) {
        long pair = 0;
        for (long val : map.values()) {
            if (val < 2) continue;
            pair += (val * (val - 1)) >> 1;
            if (pair >= k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        var obj = new CountGood_2537();
        long ans = obj.countGood(nums, k);
        System.out.println("ans = " + ans);

    }
}