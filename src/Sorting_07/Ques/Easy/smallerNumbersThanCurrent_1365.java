package Sorting_07.Ques.Easy;

import java.util.Arrays;
import java.util.HashMap;

class smallerNumbersThanCurrent_1365 {
    public static void main(String[] args) {
        int[] nums = {6,5,4,8};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int num : temp) {
            if (!map.containsKey(num)) {
                map.put(num, j);
            }
            j++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}