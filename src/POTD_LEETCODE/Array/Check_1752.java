package POTD_LEETCODE.Array;

class Check_1752 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        var obj = new Check_1752();
        System.out.println(obj.check2(nums));
    }

    public boolean check(int[] nums) {
        int prev = 0, n = nums.length, i = 1;

        while (i < n) {
            if (nums[i] < nums[prev]) {
                break;
            }
            prev = i;
            i++;
        }
        if (i == n) return true;

        while (i < (n - 1)) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
            i++;
        }
        return nums[0] >= nums[n - 1];
    }

    public boolean check2(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            }
        }
        if (nums[n - 1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }
}