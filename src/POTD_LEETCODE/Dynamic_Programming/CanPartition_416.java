package POTD_LEETCODE.Dynamic_Programming;

class CanPartition_416 {

    private Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;

        dp = new Boolean[nums.length + 1][sum + 1];
        return dfs(0, 0, sum >> 1, nums);
    }

    private boolean dfs(int i, int curr, int target, int[] nums) {
        if (curr == target) return true;
        if (curr > target) return false;
        if (i >= nums.length) return false;

        if (dp[i][curr] != null) {
            return dp[i][curr];
        }

        boolean pick = dfs(i + 1, curr + nums[i], target, nums);
        boolean notPick = dfs(i + 1, curr, target, nums);
        return dp[i][curr] = pick || notPick;
    }
}