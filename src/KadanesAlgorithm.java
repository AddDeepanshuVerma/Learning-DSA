class KadanesAlgorithm {
    public static void main(String[] args) {
        var obj = new KadanesAlgorithm();
        int[] nums = {4, -2, 3, -4, 3, -2};
        int max = obj.maxSubArraySum(nums);
        System.out.println(max);
    }

    public int maxSubArraySum(int[] nums) {
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