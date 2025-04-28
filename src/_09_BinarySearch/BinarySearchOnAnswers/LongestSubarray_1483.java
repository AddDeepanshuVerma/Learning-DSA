package _09_BinarySearch.BinarySearchOnAnswers;

import java.util.TreeMap;

class LongestSubarray_1483 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 7, 10};
        System.out.println(longestSubarray(arr, 10));
    }

    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; ++right) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);

            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                ++left;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int longestSubarray2(int[] nums, int limit) {
        int preValue = nums[0];
        int start = 0;
        int end = 0;
        int currLength = 1;
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            if (start < nums.length) {
                int diff = Math.abs(preValue - nums[i]);
                if (diff <= limit) {
                    end++;
                    preValue = Math.min(preValue, nums[i]);
                }else {
                    start++;
                    preValue = nums[i];
                }
                currLength = end - start;
                maxLength = Math.max(currLength, maxLength);
            }
        }
        return maxLength;
    }
}