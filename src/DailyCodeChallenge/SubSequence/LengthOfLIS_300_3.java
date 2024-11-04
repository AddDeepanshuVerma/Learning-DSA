package DailyCodeChallenge.SubSequence;

import java.util.Arrays;

class LengthOfLIS_300_3 {
    int[][] dp;

    public int lengthOfLIS(int[] nums) {
        int currIndex = 0, previousIndex = -1;

        dp = new int[nums.length][nums.length];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return dfs(currIndex, previousIndex, nums);
    }

    private int dfs(int index, int p, int[] nums) {
        if (index == nums.length) return 0;

        if (p != -1 && dp[index][p] != -1) return dp[index][p];

        int skip = dfs(index + 1, p, nums);
        if (p == -1 || nums[p] < nums[index]) {
            skip = Math.max(skip, 1 + dfs(index + 1, index, nums)); // Math.max(skip, take );
        }

        return p != -1 ? dp[index][p] = skip : skip;
    }

}