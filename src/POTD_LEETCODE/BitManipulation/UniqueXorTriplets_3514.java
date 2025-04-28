package POTD_LEETCODE.BitManipulation;

import java.util.HashSet;

class UniqueXorTriplets_3514 {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                set.add(nums[i] ^ nums[j]);
            }
        }

        HashSet<Integer> ans = new HashSet<>();
        for (Integer val : set) {
            for (int k = 0; k < nums.length; k++) {
                ans.add(val ^ nums[k]);
            }
        }
        return ans.size();
    }

    public int uniqueXorTriplets2(int[] nums) {
        boolean[] map = new boolean[Integer.highestOneBit(1500) << 1];

        map[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int val = nums[i] ^ nums[j];
                map[val] = true;
            }
        }

        boolean[] map2 = new boolean[Integer.highestOneBit(1500) << 1];
        for (int i = 0; i < map.length; i++) {
            if (map[i]) {
                for (int k = 0; k < nums.length; k++) {
                    int val = i ^ nums[k];
                    map2[val] = true;
                }
            }
        }

        int count = 0;
        for (boolean flag : map2) {
            if (flag) count++;
        }
        return count;
    }
}