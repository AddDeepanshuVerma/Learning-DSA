package POTD_LEETCODE.sliding_window;

import java.util.HashMap;

// n :: optimal solution
class CountGood_2537_2 {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, n = nums.length;
        long count = 0;
        long pairCount = 0;
        for (int j = 0; j < n; j++) {
            long add = map.merge(nums[j], 1, Integer::sum);
            pairCount += (add * (add - 1)) >> 1;
            add--;
            pairCount -= (add * (add - 1)) >> 1;

            while (pairCount >= k) {
                count += n - j;
                long sub = map.merge(nums[i], -1, Integer::sum);

                pairCount += (sub * (sub - 1)) >> 1;
                sub++;
                pairCount -= (sub * (sub - 1)) >> 1;

                i++;
            }
        }

        return count;
    }

    public long countGood2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, n = nums.length;
        long count = 0;
        long pairCount = 0;
        for (int j = 0; j < n; j++) {
            long add = map.merge(nums[j], 1, Integer::sum);
            pairCount += (add * (add - 1)) >> 1;
            add--;
            pairCount -= (add * (add - 1)) >> 1;

            while (pairCount >= k) {
                count += n - j;
                long sub = map.merge(nums[i], -1, Integer::sum);

                pairCount += (sub * (sub - 1)) >> 1;
                sub++;
                pairCount -= (sub * (sub - 1)) >> 1;

                i++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int k = 2;
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        var obj = new CountGood_2537_2();
        long ans = obj.countGood2(nums, k);
        System.out.println("ans = " + ans);
    }
}