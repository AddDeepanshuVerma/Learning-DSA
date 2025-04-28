package LeetCode_33Question_challenge_2025.week3;

public class Q1 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int start = 0, end = n - 1;
        int idx = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
//        int[] arr = {6, 5, 4, 3, 2, 3, 2};
        int[] arr = {1, 2, 3, 4, 5};
        var obj = new Q1();
        int ans = obj.findPeakElement(arr);
        System.out.println("ans = " + ans);
    }
}
