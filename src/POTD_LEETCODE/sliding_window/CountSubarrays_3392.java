package POTD_LEETCODE.sliding_window;

class CountSubarrays_3392 {
    public static int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i - 2] + nums[i]) << 1 == nums[i - 1]) {
                count++;
            }
        }
        return count;
    }

    public static int countSubarrays2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] + nums[i + 2]) << 1 == nums[i + 1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, -7, -6};
        int ans = countSubarrays(nums);
        System.out.println("ans = " + ans);
    }
}