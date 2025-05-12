package POTD_LEETCODE.Greedy;

class MinSum_2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;

        for (int val : nums1) {
            sum1 += val == 0 ? 1 : val;
            zero1 += val == 0 ? 1 : 0;
        }

        for (int val : nums2) {
            sum2 += val == 0 ? 1 : val;
            zero2 += val == 0 ? 1 : 0;
        }

        if (zero1 == 0 && zero2 == 0) return sum2 == sum1 ? sum2 : -1;

        if(zero1 == 0 && sum1 < sum2) return -1;
        if(zero2 == 0 && sum2 < sum1) return -1;

        return Math.max(sum2, sum1);
    }
}