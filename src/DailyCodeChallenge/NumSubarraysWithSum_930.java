package DailyCodeChallenge;

import java.util.Arrays;
import java.util.HashMap;

class NumSubarraysWithSum_930 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(numSubarraysWithSum(arr, 2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        // make given array a binary array odd == 1, even == 0
        Arrays.setAll(nums, i -> ((nums[i] & 1) == 1) ? 1 : 0);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ((nums[i] & 1) == 1) ? 1 : 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0, count = 0;
        for (int num : nums) {
            preSum += num;
            int key = preSum - goal;
            count += map.getOrDefault(key, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}