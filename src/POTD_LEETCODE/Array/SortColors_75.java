package POTD_LEETCODE.Array;

class SortColors_75 {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            switch (num) {
                case 0 -> zero++;
                case 1 -> one++;
                default -> two++;
            }
        }

        int i = 0;
        while (zero-- > 0) nums[i++] = 0;
        while (one-- > 0) nums[i++] = 1;
        while (two-- > 0) nums[i++] = 2;
    }

    public void sortColors2(int[] nums) {
        int low = 0, high = nums.length - 1;
        int curr = 0;
        while (curr <= high) {
            int num = nums[curr];
            switch (num) {
                case 0 -> swap(nums, curr++, low++);
                case 1 -> curr++;
                case 2 -> swap(nums, curr, high--);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
    }
}