package DailyCodeChallenge.SubSequence;

import java.util.Arrays;

class LengthOfLIS_300_3 {
    int[] dp;

    public int lengthOfLIS(int[] nums) {
        int currIndex = 0, previousIndex = -1;

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return dfs(currIndex, previousIndex, nums);
    }

    private int dfs(int index, int p, int[] nums) {
        if (index == nums.length) return 0;

        if (dp[index] != -1) {
            return dp[index];
        }

        int res = 0;
        if (p == -1 || nums[p] < nums[index]) {
            res = Math.max(res, 1 + dfs(index + 1, index, nums));
        }

        res = Math.max(res, dfs(index + 1, p, nums));

        return dp[index] = res;
    }

}