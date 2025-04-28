package POTD_LEETCODE.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class MinimumIndex_2780 {
    public int minimumIndex(List<Integer> nums) {
        int count = 0, element = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            int val = map.merge(num, 1, Integer::sum);
            if (val > count) {
                count = val;
                element = num;
            }
        }

        int n = nums.size();
        if (count < n >> 1) return -1;

        // now in first half we have to count element occurance > ((n/2) / 2)
        int i = 0, occur = 0;
        while (i < n && occur <= (i >> 1)) {
            if (nums.get(i) == element) {
                occur++;
            }
            i++;
        }
        int split = i - 1;

        // now we need to count the max occurance element in second half
        map = new HashMap<>();
        int newCount = 0, newElement = -1;
        while (i < n) {
            int val = map.merge(nums.get(i), 1, Integer::sum);
            if (val > newCount) {
                newCount = val;
                newElement = nums.get(i);
            }
            i++;
        }

        return newElement == element && newCount > ((n - split - 1) >> 1) ? split : -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,1,1));
        var obj = new MinimumIndex_2780();
        System.out.println(obj.minimumIndex(list));
    }
}