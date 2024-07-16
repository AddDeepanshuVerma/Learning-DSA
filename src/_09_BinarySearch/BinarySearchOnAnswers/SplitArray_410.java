package _09_BinarySearch.BinarySearchOnAnswers;

import java.util.Arrays;

class SplitArray_410 {
    public static void main(String[] args) {
        int[] arr = {2, 16, 14, 15};
        System.out.println(splitArray(arr, 2));
    }

    public static int splitArray(int[] nums, int k) {
        Arrays.sort(nums);
//        start : min range : minimal max element will be when splitting the array in size 1 of n subArrays
//        end : max range of our answer would be when splitting the array in 1 subArray only
        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }
        // now search minimum answer in the range of [start, end]
        // which will satisfy k subArray in our nums
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (parts(nums, mid) <= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int parts(int[] nums, int mid) {
        // can we divide nums arrays in exactly k parts with each past sum would be max of mid-value
        int sum = 0;
        int parts = 1;
        for (int num : nums) {
            if (sum + num > mid) {
                sum = num;
                parts++;
            } else sum += num;
        }
        return parts;
    }
}