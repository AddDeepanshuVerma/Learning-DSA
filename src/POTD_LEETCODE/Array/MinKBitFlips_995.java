package POTD_LEETCODE.Array;

class MinKBitFlips_995 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int i = 0, count = 0;
        for (i = 0; i <= n - k; i++) {
            if (nums[i] == 1) continue;
            count++;
            for (int j = i; j < i + k; j++) {
                nums[j] = 1 - nums[j];
            }
        }

        while (i < n) {
            if (nums[i++] == 0) {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 0, 1, 1, 0};
        int k = 3;
        var obj = new MinKBitFlips_995();
        System.out.println(obj.minKBitFlips(nums, k));
    }
}