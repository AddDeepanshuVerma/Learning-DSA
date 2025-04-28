package _07_Sorting.Ques.Easy;

import java.util.Arrays;
import java.util.HashMap;

class twoSum_1 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1};
        System.out.println(Arrays.toString(twoSum(nums, 11)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int n : nums) {
            map.put(target - n, map.getOrDefault(target - n, j));
                    j++;
        }
//        Arrays.stream(nums).forEach(n -> map.put(target - n, map.getOrDefault(target - n, map.size())));
        System.out.println(map);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
        }
        return null;
    }
}