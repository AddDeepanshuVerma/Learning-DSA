package Contest.Biweekly_Contest._140;

class MinElement_1 {
    public int minElement(int[] nums) {
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            small = Math.min(small , digitSum(nums[i]));
        }
        return small;
    }

    private int digitSum(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}