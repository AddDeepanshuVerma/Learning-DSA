package _06_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum_18_3 {
    public static void main(String[] args) {
        int[]ints2 = {1000000000,1000000000,1000000000,1000000000};
        int[]ints = {2,2,2,2,2};
        List<List<Integer>> lists = fourSum(ints, 8); //[-2,-1,1,2]
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> resSet = new HashSet<>();
        int n = nums.length;
        long sum = target;
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < n; j++) {
//                if(j < n && nums[j] == nums[j-1]) continue;
                sum = sum - nums[i];
                sum = sum - nums[j];
                int start = j+1, end = n-1;
                twoPointerSum(resSet, nums, start, end, sum, nums[i], nums[j]);
                sum = target;
            }
        }
        return new ArrayList<>(resSet);
    }

    private static void twoPointerSum(HashSet<List<Integer>> resSet,int[] nums, int start, int end, long target, int i, int j) {
        while (start < end) {
            long sum2 = 0;
             sum2 += nums[start];
             sum2 += nums[end];
            if(sum2 < target ){
                start++;
            } else if (sum2 > target) {
                end--;
            }else if (sum2 == target){
                resSet.add(Arrays.asList(i, j, nums[start], nums[end]));
                start++;
                end--;
            }
        }
    }
}
