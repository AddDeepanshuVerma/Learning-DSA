package Random;

import java.util.HashMap;
import java.util.Map;

public class checkSubArraySum_523 {
    public static void main(String[] args) {
        int[] arr = {-3, 3, 1, 1, 1};
        int[] arr2 = {0,0,0,1,0,0,1,0,0,0};
        System.out.println(checkSubArraySum(arr2, 2));
    }

    public static int checkSubArraySum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0, count = 0;
        map.put(0, 1);
        for (int j : arr) {
            preSum += j;
            count += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        System.out.println(map);
        return count;
    }

}
