package Searching_06;

import java.util.*;

public class FourSum_18 {
    public static void main(String[] args) {
        int[]ints2 = {-5,5,4,-3,0,0,4,-2};
        int[]ints = {1,0,-1,0,0,-2,2};
        List<List<Integer>> lists = fourSum(ints2, 4);
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        sum += nums[i];
                        sum += nums[j];
                        sum += nums[k];
                        sum += nums[l];
                        if (sum == target) {
                            List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            Collections.sort(list);
                            set.add(list);
                        }
                        sum = 0;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
//        return new ArrayList<>(set);
    }
}
