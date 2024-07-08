package Top_150;

class CanJump_55 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        int maxReachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachable) return false;
            if (maxReachable >= nums.length - 1) return true;
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}