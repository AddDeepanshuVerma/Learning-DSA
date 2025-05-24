package POTD_LEETCODE.Greedy;

class MaximumValueSum_3068 {
    // This Q can be done using Dynamic programming with [n][3] matrix
    // but the optimized solution is greedy one, here briefing is that Pair wise we can take xor
    // hence if we happen to take odd number of XORs it means one need to being either remove or add to make it EVEN
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int count = 0;
        long sum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            if ((num ^ k) > num) {
                count++;
                sum += num ^ k;
            } else {
                sum += num;
            }

            minDiff = Math.min(minDiff, Math.abs(num - (num ^ k)));
        }

        return (count & 1) == 0 ? sum : sum - minDiff;
    }
}