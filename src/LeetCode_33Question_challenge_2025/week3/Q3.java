package LeetCode_33Question_challenge_2025.week3;

public class Q3 {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        if (end == 0) return end;

        while (start <= end) {
            if (start == end) return start;
            int mid = (start + end) >>> 1;
            if (nums[mid] > nums[mid + 1]) end = mid;
            else start = mid + 1;
        }
        return 0;
    }
}
