package Sorting_07.Ques.Medium;

import java.util.*;

class fourSum_18 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        List<List<Integer>> lists = fourSum2(arr, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                // now find two more elements where 4sum == target
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[start];
                    sum += nums[end];
                    if (sum > target) end--;
                    else if (sum < target) start++;
                    else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) start++;
                        while (start < end && nums[end] == nums[end + 1]) end--;
                    }
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // now find two more elements where 4sum == target
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[start];
                    sum += nums[end];
                    if (sum > target) end--;
                    else if (sum < target) start++;
                    else {
                        set.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;

                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}