package _06_Searching;

import java.util.*;

public class FourSum_18_2 {
    public static void main(String[] args) {
        int[]ints2 = {1000000000,1000000000,1000000000,1000000000};
        int[]ints = {1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum(ints2, -294967296); //[-2,-1,1,2]
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> resSet = new HashSet<>();
        int n = nums.length;
        long sum = target;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //Search element in array whose sum would be
                // sum = sum - (nums[i] + nums[j]);
                // start index = j+1, end index = n-1;
                sum = sum - nums[i];
                sum = sum - nums[j];
                int start = j+1, end = n-1;
                List<List<Integer>> lst= twoPointerSum(nums, start, end, sum, nums[i], nums[j]);
                if (!lst.isEmpty()) {
                    resSet.addAll(lst);
                }
                sum = target;
            }
        }
        return new ArrayList<>(resSet);
    }

    private static List<List<Integer>> twoPointerSum(int[] nums, int start, int end, long target, int i, int j) {
        List<List<Integer>> res = new ArrayList<>();
        while (start < end) {
//            long sum2 = nums[start] + nums[end];
            long sum2 = 0;
             sum2 += nums[start];
             sum2 += nums[end];
            if(sum2 < target ){
                start++;
            } else if (sum2 > target) {
                end--;
            }else if (sum2 == target){
                res.add(Arrays.asList(i, j, nums[start], nums[end]));
                start++;
                end--;
            }
        }
        return res;
    }
}
