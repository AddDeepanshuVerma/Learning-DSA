package POTD_LEETCODE.Dynamic_Programming;

// Recursion using knapSack : pick & skip, Need to apply memoization
class MaximumValueSum_3068 {
    static class MaximumValueSum_3068_recursion {
        public long maximumValueSum(int[] nums, int k, int[][] edges) {
            // pick & notPick the current index
            int i = 0;
            int oddEven = 0;
            return dfs(i, k, oddEven, nums);
        }

        private long dfs(int i, int k, int oddEven, int[] nums) {
            if (i == nums.length) {
                return oddEven == 0 ? 0 : Integer.MIN_VALUE;
            }

            long pick = (nums[i] ^ k) + dfs(i + 1, k, 2 - oddEven, nums);
            long skip = nums[i] + dfs(i + 1, k, oddEven, nums);

            return Math.max(skip, pick);
        }
    }

    static class MaximumValueSum_3068_memoization {
        public long maximumValueSum(int[] nums, int k, int[][] edges) {
            // pick & notPick the current index
            int i = 0, oddEven = 0;
            return dfs(i, k, oddEven, nums, new Long[nums.length][3]);
        }

        private long dfs(int i, int k, int oddEven, int[] nums, Long[][] dp) {
            if (i == nums.length) {
                return oddEven == 0 ? 0 : Integer.MIN_VALUE;
            }
            if (dp[i][oddEven] != null) {
                return dp[i][oddEven];
            }

            long pick = (nums[i] ^ k) + dfs(i + 1, k, 2 - oddEven, nums, dp);
            long skip = nums[i] + dfs(i + 1, k, oddEven, nums, dp);

            return dp[i][oddEven] = Math.max(skip, pick);
        }
    }
}