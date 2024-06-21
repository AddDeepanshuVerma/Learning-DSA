package Searching_06;

import jdk.jfr.Description;

import java.util.Arrays;

public class MinAbsoluteSumDiff_1818 {
    static int[] arr1 = {1,10,4,4,2,7};
    static int[] arr2 = {9,3,5,1,7,4};
    public static void main(String[] args) {
//        System.out.println(minAbsoluteSumDiff(arr1,arr2));
        int[] sArr = {1,2,4,4,7,10};
        System.out.println(binarySearch(sArr,6));
    }
    @Description("unique start + 1 < end")
    private static long binarySearch(int[] arr, long target) {
        int start = 0,
                end = arr.length-1,
                mid = 0;
        while (start +1 < end) {
            mid = start + (end - start)/2;
            if (arr[mid] < target) {
                start = mid;
            } else if (target < arr[mid]) {
                end = mid;
            }else{
                return target;
            }
        }
        if(Math.abs(arr[start] - target) < Math.abs(arr[end] - target)){
            return arr[start];
        }else{
            return arr[end];
        }
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long sum = 0,
                ans  = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            sum = sum + Math.abs(nums1[i] - nums2[i]);
        }
        if (sum == 0) return 0;
        int[] num1clone = nums1.clone();
        Arrays.sort(num1clone);
        for (int i = 0; i < nums2.length; i++) {
            if (Math.abs(nums1[i] - nums2[i]) == 0) continue;
            long element = binarySearch(num1clone, nums2[i]);
            long oldDiff = Math.abs(nums1[i] - nums2[i]);
            long newDiff = Math.abs(element - nums2[i]);
            if (newDiff <= oldDiff) {
                ans = Math.min(ans, sum - oldDiff + newDiff);
            }
        }
        return (int)ans;
    }
}












