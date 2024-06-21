package Sorting_07.Ques.Easy;

import java.util.Arrays;
import java.util.HashMap;

class majorityElement_169 {
    public static void main(String[] args) {
        int i = majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }

    public static int majorityElement2(int[] nums) {
        int repeat = nums.length/2;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > repeat) {
                    return nums[i];
                }
            }else count = 1;
        }
        return -1;
    }


    public static int majorityElement(int[] nums) {
        int repeat = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > repeat) {
                return i;
            }
        }
        return -1;
    }
}