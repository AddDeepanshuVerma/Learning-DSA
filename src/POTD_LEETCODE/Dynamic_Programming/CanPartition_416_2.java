package POTD_LEETCODE.Dynamic_Programming;

class CanPartition_416_2 {

    private Boolean[][] dp;
    private int target;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        target = sum >> 1;

        dp = new Boolean[nums.length + 1][sum + 1];
//        return dfs(0, 0, nums);
        return dfs2(0, 0, nums);
    }

    private boolean dfs(int i, int curr, int[] nums) {
        if (curr == target) return true;
        if (curr > target || i >= nums.length) return false;

        if (dp[i][curr] != null) {
            return dp[i][curr];
        }

        boolean pick = dfs(i + 1, curr + nums[i], nums);
        if (pick) return dp[i][curr] = true;
        boolean notPick = dfs(i + 1, curr, nums);
        return dp[i][curr] = notPick;
    }

    private boolean dfs2(int i, int curr, int[] nums) {
        if (curr == target) return true;
        if (curr > target || i >= nums.length) return false;

        if (dp[i][curr] != null) {
            return dp[i][curr];
        }

        return dp[i][curr] = dfs2(i + 1, curr + nums[i], nums) || dfs2(i + 1, curr, nums);
    }
}