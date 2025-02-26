class KadanesAlgorithm {
    public int Kadanes_Algorithm(int[] nums) {
        int maxSum = nums[0];
        int currSumMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //Either we start new subArray with current element or merge this current element with previous sum
            currSumMax = Math.max(nums[i], currSumMax + nums[i]);

            maxSum = Math.max(maxSum, currSumMax);
        }
        return maxSum;
    }
}