package POTD_LEETCODE.BackTracking;

class CountMaxOrSubsets_2044_3 {
    int max, count;

    public int countMaxOrSubsets(int[] nums) {
        max = getOR(nums);
        count = 0;
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int res) {
        if (index == nums.length) {
            if (res == max) count++;
            return;
        }

        // either we take this index or not
        dfs(nums, index + 1, res | nums[index]);
        dfs(nums, index + 1, res);
    }

    private int getOR(int[] nums) {
        int ans = 0;
        for (int num : nums) ans |= num;
        return ans;
    }
}