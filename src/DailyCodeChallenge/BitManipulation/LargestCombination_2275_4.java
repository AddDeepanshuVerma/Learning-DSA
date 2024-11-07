package DailyCodeChallenge.BitManipulation;

class LargestCombination_2275_4 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));

        LargestCombination_2275_4 obj = new LargestCombination_2275_4();
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        System.out.println(obj.largestCombination(candidates));
    }

    private int largestCombination(int[] nums) {
        int maxCount = 0;
        for (int i = 0; i < 24; i++) {
            int count = 0;
            for (int num : nums) {
                count += ((num >> i) & 1);
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private int largestCombination2(int[] nums) {
        int maxCount = 0;
        for (int i = 0; i < 31; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

}