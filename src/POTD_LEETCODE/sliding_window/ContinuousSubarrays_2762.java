package POTD_LEETCODE.sliding_window;

import jdk.jfr.Description;

import java.util.TreeMap;

class ContinuousSubarrays_2762 {
    @Description("compact version")
    public long continuousSubarrays2(int[] nums) {
        long ans = 0;
        int i = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int j = 0; j < nums.length; j++) {
            map.merge(nums[j], 1, Integer::sum);
            while (!isValid(map)) {
                int val = map.merge(nums[i], -1, Integer::sum);
                if (val == 0) map.remove(nums[i]);
                i++;
            }
            ans += (j - i + 1);
        }
        return ans;
    }

    @Description(" Slight lengthy ")
    public long continuousSubarrays(int[] nums) {
        long ans = 0;

        int i = 0, j = 0, n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (j < n) {
            map.merge(nums[j], 1, Integer::sum);
            while (!isValid(map)) {
                int val = map.merge(nums[i], -1, Integer::sum);
                if (val == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            ans += (j - i + 1);
            j++;
        }
        return ans;
    }

    private boolean isValid(TreeMap<Integer, Integer> map) {
        if (map.size() < 2) {
            return true;
        }
        int first = map.firstEntry().getKey();
        int last = map.lastEntry().getKey();
        int diff = Math.abs(last - first);

//        return diff < 0 || diff > 2 ? false : true;
        return diff >= 0 && diff <= 2;
    }
}