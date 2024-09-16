package Contest.Weekly_Contest._415;

import java.util.HashMap;
import java.util.Map;

class GetSneakyNumbers_1 {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (set.getValue() > 1) {
                ans[i++] = set.getKey();
                if (i == 2) {
                    break;
                }
            }
        }
        return ans;
    }
}