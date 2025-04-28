package LeetCode_33Question_challenge_2025.week3;

public class Q11 {
    public int trap(int[] arr) {
        int start = 0, end = arr.length - 1;
        int leftMax = 0, rightMax = 0;
        int count = 0;

        while (start < end) {
            rightMax = Math.max(rightMax, arr[end]);
            leftMax = Math.max(leftMax, arr[start]);

            if (leftMax < rightMax) {
                count += leftMax - arr[start];
                start++;
            } else {
                count += rightMax - arr[end];
                end--;
            }
        }
        return count;
    }
}
