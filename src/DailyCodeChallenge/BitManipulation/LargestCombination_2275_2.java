package DailyCodeChallenge.BitManipulation;

class LargestCombination_2275_2 {
    public static void main(String[] args) {
        LargestCombination_2275_2 obj = new LargestCombination_2275_2();
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
//        int[] candidates = {8, 8};
        System.out.println(obj.largestCombination(candidates));
    }

    public int largestCombination(int[] candidates) {
        int index = 0, length = 0;
//        int result = (1 << 31) - 1;// a number with all 1's in binary
        int result = -1;// a number with all 1's in binary
        return dfs(index, result, candidates);
    }

    private int dfs(int index, int result, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        int skip = dfs(index + 1, result, nums);
        int take = 0;
        if ((result & nums[index]) != 0) {
            take = 1 + dfs(index + 1, result & nums[index], nums);
        }

        return Math.max(take, skip);
    }
}