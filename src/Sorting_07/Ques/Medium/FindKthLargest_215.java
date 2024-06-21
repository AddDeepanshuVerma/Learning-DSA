package Sorting_07.Ques.Medium;

import java.util.Arrays;

class FindKthLargest_215 {
    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}