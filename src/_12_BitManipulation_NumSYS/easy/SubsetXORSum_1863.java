package _12_BitManipulation_NumSYS.easy;

class SubsetXORSum_1863 {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

    private int solve(int[] nums, int n, int res) {
        if (n == nums.length) {
            return res;
        }
        int sumOfLeft_Xored_elements = solve(nums, n + 1, res);
        int sumOfRight_Xored_elements = solve(nums, n + 1, res ^ nums[n]);
        return sumOfLeft_Xored_elements + sumOfRight_Xored_elements;
    }
}