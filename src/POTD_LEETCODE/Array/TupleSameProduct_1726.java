package POTD_LEETCODE.Array;

import java.util.HashMap;
import java.util.Map;

class TupleSameProduct_1726 {
    public static void main(String[] args) {
        var obj = new TupleSameProduct_1726();
//        int[] nums = {1, 2, 4, 5, 10};
        int[] nums = {2, 3, 4, 6, 8, 12};
        System.out.println(obj.tupleSameProduct(nums));
    }

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
//                map.put(nums[i] * nums[j], map.getOrDefault(0) + 1);
                map.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            int value = item.getValue();
            if (value > 1) {
                count += ((value * (value - 1)) >> 1) * 8;
            }
        }
        return count;
    }

    public int tupleSameProduct2(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }

        int count = 0;
        for (Integer val : map.values()) {
            if (val > 1) {
                count += val * (val - 1);
            }
        }
        return count << 2;
    }
}