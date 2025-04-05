package POTD_LEETCODE.Recursion;

class SubsetXORSum_1863 {
    public int subsetXORSum(int[] nums) {
        int xor = 0;
        return dfs(0, xor, nums);
    }

    private int dfs(int i, int xor, int[] nums) {
        if (i == nums.length) return xor;
        int pick = dfs(i + 1, xor ^ nums[i], nums);
        int notPick = dfs(i + 1, xor, nums);
        return pick + notPick;
    }
}