package POTD_LEETCODE.Level_2;

import java.util.Arrays;

class SmallestDistancePair_719_3 {

    public static void main(String[] args) {
        int[] nums = {1,3,1};
        int k = 1;
        SmallestDistancePair_719_3 obj = new SmallestDistancePair_719_3();
        System.out.println(obj.smallestDistancePair(nums, k));
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums[nums.length - 1];
        int ans = -1;
        while (start <= end) {
            int mid = start + end >>> 1;
            if (totalPair(nums, mid) >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private int totalPair(int[] nums, int mid) {
        int count = 0;
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] <= nums[i] + mid) j++;
            count = count + (j - i) - 1;
//            j = 1;
        }
        return count;
    }
}