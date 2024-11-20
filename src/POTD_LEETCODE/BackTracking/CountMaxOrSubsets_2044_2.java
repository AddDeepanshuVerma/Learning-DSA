package POTD_LEETCODE.BackTracking;

class CountMaxOrSubsets_2044_2 {
    int max, count;

    public int countMaxOrSubsets(int[] nums) {
        max = -1;
        count = -1;
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int res) {
        if (index == nums.length) {
            if (res == max) {
                count++;
            } else if (res > max) {
                max = res;
                count = 1;
            }
            return;
        }

        // either we take this index or not
        dfs(nums, index + 1, res | nums[index]);
        dfs(nums, index + 1, res);
    }
}