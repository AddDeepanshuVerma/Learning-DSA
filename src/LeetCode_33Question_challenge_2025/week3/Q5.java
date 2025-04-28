package LeetCode_33Question_challenge_2025.week3;

public class Q5 {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReached = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && maxReached <= i) break;
            maxReached = Math.max(maxReached, i + nums[i]);
        }
        return maxReached >= (n - 1);
    }

    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        int maxReached = nums[0];
        for (int curr = 0; curr < n; curr++) {
            if (maxReached < curr) return false;
            maxReached = Math.max(maxReached, curr + nums[curr]);
        }
        return true;
    }

    public static boolean canJump3(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        for (int curr = 0; curr < n; curr++) {
            if (maxReach < curr) return false;
            maxReach = Math.max(maxReach, curr + nums[curr]);
        }
        return maxReach >= n - 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(canJump(nums));
    }
}
