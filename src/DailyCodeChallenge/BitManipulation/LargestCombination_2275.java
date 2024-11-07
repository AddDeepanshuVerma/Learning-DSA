package DailyCodeChallenge.BitManipulation;

class LargestCombination_2275 {
    public static void main(String[] args) {
        LargestCombination_2275 obj = new LargestCombination_2275();
//        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        int[] candidates = {33, 93, 31, 99, 74, 37, 3, 4, 2, 94, 77, 10, 75, 54, 24, 95, 65, 100, 41, 82, 35, 65, 38, 49, 85, 72, 67, 21, 20, 31};
        System.out.println(obj.largestCombination(candidates));
    }

    int maxLength;

    public int largestCombination(int[] candidates) {
        maxLength = 1;
        int index = 0, length = 0;
        int result = (1 << 31) - 1;// a number with all 1's in binary
        dfs(index, length, result, candidates);

        return maxLength;
    }

    private void dfs(int index, int length, int result, int[] nums) {
        if (index == nums.length) {
            if (result > 0) maxLength = Math.max(maxLength, length);
            return;
        }

        dfs(index + 1, length, result, nums);// skip current index
        dfs(index + 1, length + 1, result & nums[index], nums);// take current index
    }
}