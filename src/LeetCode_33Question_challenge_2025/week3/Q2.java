package LeetCode_33Question_challenge_2025.week3;

public class Q2 {
    public int longestMonotonicSubarray(int[] nums) {
        int incCount = 1, decCount = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incCount++;
                decCount = 1;
                max = Math.max(max, incCount);
            } else if (nums[i] < nums[i - 1]) {
                decCount++;
                incCount = 1;
                max = Math.max(max, decCount);
            } else {
                incCount = 1;
                decCount = 1;
            }
        }
        return max;
    }
}
