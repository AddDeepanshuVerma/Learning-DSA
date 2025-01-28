package POTD_LEETCODE.Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class LexicographicallySmallestArray_2948 {
    public static void main(String[] args) {
        int[] arr = {10, 2, 7, 3, 8, 4, 9, 6, 3};
        int[] ans = lexicographicallySmallestArray_tle(arr, 1);
        System.out.println("ans = " + Arrays.toString(ans));
    }

    //TLE : n^2
    public static int[] lexicographicallySmallestArray_tle(int[] nums, int limit) {
        int n = nums.length, i = 0;
        while (i < n) {
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= limit && nums[j] < nums[i]) {
                    found = true;
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            if (!found) i++;
        }
        return nums;
    }

    public static int[] lexicographicallySmallestArray_optimal(int[] nums, int limit) {
        int[] temp = nums.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> valToGrp = new HashMap<>();
        HashMap<Integer, ArrayDeque<Integer>> grpToItems = new HashMap<>();

        int currGroup = 0;
        valToGrp.put(temp[0], currGroup);
        grpToItems.put(currGroup, new ArrayDeque<>(List.of(temp[0])));

        for (int i = 1; i < temp.length; i++) {
            if (Math.abs(temp[i] - temp[i - 1]) > limit) {
                currGroup++;
            }
            valToGrp.put(temp[i], currGroup);
            grpToItems.computeIfAbsent(currGroup, dq -> new ArrayDeque<>()).addLast(temp[i]);
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int group = valToGrp.get(nums[i]);
            int poll = grpToItems.get(group).removeFirst();
            ans[i] = poll;
        }
        return ans;
    }

    public int[] lexicographicallySmallestArray_concised(int[] nums, int limit) {
        int[] temp = nums.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> valToGrp = new HashMap<>();
        HashMap<Integer, ArrayDeque<Integer>> grpToItems = new HashMap<>();

        int currGroup = 0;
        valToGrp.put(temp[0], currGroup);
        grpToItems.put(currGroup, new ArrayDeque<>(List.of(temp[0])));

        for (int i = 1; i < temp.length; i++) {
            if (Math.abs(temp[i] - temp[i - 1]) > limit) currGroup++;
            valToGrp.put(temp[i], currGroup);
            grpToItems.computeIfAbsent(currGroup, dq -> new ArrayDeque<>()).addLast(temp[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = grpToItems.get(valToGrp.get(nums[i])).removeFirst();
        }
        return nums;
    }

}