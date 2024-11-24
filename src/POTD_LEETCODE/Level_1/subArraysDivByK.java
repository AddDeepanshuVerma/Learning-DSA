package POTD_LEETCODE.Level_1;

import java.util.HashMap;

public class subArraysDivByK {
    public static void main(String[] args) {

    }
    public static int subArraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0, count = 0, add = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            // As negative value are there to get their reminder
            // we need to do : -10%2 = -1 => -1+2 => 1 => 1%3 => 1
            add = ((preSum % k)+k)%k ;
            if (map.containsKey(add)) {
                count = count + map.get(add);
            }
            map.put(add, map.getOrDefault(add, 0)+1);
        }
        System.out.println(map);
        return count;
    }
}
