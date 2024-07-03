package DailyCodeChallenge;

import java.util.Arrays;

class MinDifference_1509 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 10, 14, 15, 20, 33, 22, 2, 1, 2, 3, 2, 1, 3, 4, 45, 2, 1, 1};
        System.out.println(minDifference(arr));
    }

    public static int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;

        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i <= 3; ++i)
            ans = Math.min(ans, nums[n - 4 + i] - nums[i]);
        return ans;
    }
}