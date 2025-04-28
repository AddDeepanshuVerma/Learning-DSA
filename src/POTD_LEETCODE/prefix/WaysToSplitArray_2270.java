package POTD_LEETCODE.prefix;

class WaysToSplitArray_2270 {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num : nums) sum += num;

        int count = 0, n = nums.length;
        long currSum = 0;
        for (int i = 0; i < n - 1; i++) {
            currSum += nums[i];
            if (currSum > (sum - currSum)) {
                count++;
            }
        }
        return count;
    }
}