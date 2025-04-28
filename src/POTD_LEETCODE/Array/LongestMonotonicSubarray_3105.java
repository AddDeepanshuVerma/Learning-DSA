package POTD_LEETCODE.Array;

class LongestMonotonicSubarray_3105 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.println(longestMonotonicSubarray3(nums));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        int max = 1, inc = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                max = Math.max(max, inc);
            } else inc = 1;
        }

        int desc = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                desc++;
                max = Math.max(max, desc);
            } else desc = 1;
        }
        return max;
    }

    public static int longestMonotonicSubarray2(int[] nums) {
        int max = 1, inc = 1, desc = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                max = Math.max(max, inc);
            } else inc = 1;

            if (nums[i] < nums[i - 1]) {
                desc++;
                max = Math.max(max, desc);
            } else desc = 1;
        }
        return max;
    }

    public static int longestMonotonicSubarray3(int[] nums) {
        int ans = 1;
        for (int inc = 1, desc = 1, i = 1; i < nums.length; i++) {
            inc = nums[i - 1] < nums[i] ? inc + 1 : inc;
            desc = nums[i - 1] > nums[i] ? desc + 1 : desc;
            ans = Math.max(ans, Math.max(desc, inc));
        }
        return ans;
    }
}