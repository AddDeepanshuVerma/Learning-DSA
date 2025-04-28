package POTD_LEETCODE.Array;

class IsArraySpecial_3151 {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & 1) + (nums[i - 1] & 1) != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isArraySpecial2(int[] nums) {
        int prev = nums[0] & 1;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i] & 1;
            if (curr == prev) {
                return false;
            } else {
                prev = curr;
            }
        }
        return true;
    }
}