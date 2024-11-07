package DailyCodeChallenge.BitManipulation;

class LargestCombination_2275_3 {
    public static void main(String[] args) {
        LargestCombination_2275_3 obj = new LargestCombination_2275_3();
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
//        int[] candidates = {8, 8};
        System.out.println(obj.largestCombination(candidates));
    }

    public int largestCombination(int[] candidates) {
        int index = 0, length = 0, totalAnd = 0;
        int result = -1;// a number with all 1's in binary

        return solve(candidates, index, result, totalAnd);
    }

    private int solve(int[] nums, int i, int and, int count) {
        if (i == nums.length) {
            return (and > 0) ? count : 0;
        }

        int take = solve(nums, i + 1, and & nums[i], count + 1);
        int not_take = solve(nums, i + 1, and, count);

        return Math.max(not_take, take);
    }
}