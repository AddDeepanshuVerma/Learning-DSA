package LeetCode_33Question_challenge_2025.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Q3_ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int required = -(nums[i] + nums[j]);
                if (map.containsKey(required)) {
                    int index = map.get(required);
                    if (index > j) {
                        ans.add(List.of(nums[i], nums[j], nums[index]));
                    }
                }

            }
        } return ans;
    }

    public static void main(String[] args) {
        var obj = new Q3_ThreeSum_15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = obj.threeSum(nums);
        System.out.println("ans = " + ans);
    }
}