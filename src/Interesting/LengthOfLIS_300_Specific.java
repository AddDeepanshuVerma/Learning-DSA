package Interesting;

import java.util.TreeMap;

class LengthOfLIS_300_Specific {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer, Integer> lis = new TreeMap<>();

        for (int num : nums) {
            Integer ceil = lis.ceilingKey(num);
            if (ceil != null) lis.remove(ceil);
            lis.put(num, 0);
        }

        return lis.size();
    }
}