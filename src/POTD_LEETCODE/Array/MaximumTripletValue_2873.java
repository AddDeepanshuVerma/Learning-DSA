package POTD_LEETCODE.Array;

class MaximumTripletValue_2873 {
    // n^3
    public long maximumTripletValue(int[] nums) {
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    ans = Math.max(ans, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        return ans;
    }

    // n^2
    public long maximumTripletValue2(int[] nums) {
        int n = nums.length;
        int[] preFix = new int[n];
        preFix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            preFix[i] = Math.max(preFix[i + 1], nums[i]);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                ans = Math.max(ans, (long) (nums[i] - nums[j]) * preFix[j + 1]);
            }
        }

        return ans;
    }

    // n
    public long maximumTripletValue3(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        suffix[n - 1] = nums[n - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(nums[i], suffix[i + 1]);
        }

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.max(nums[i], prefix[i - 1]);
        }

        long ans = 0;
        for (int k = 1; k < nums.length - 1; k++) {
            ans = Math.max(ans, (long) (prefix[k - 1] - nums[k]) * suffix[k + 1]);
        }
        return ans;
    }

    // n :: 1
    public long maximumTripletValue4(int[] nums) {
        int maxDifference = 0;
        int maxElement = 0;
        long ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, (long) maxDifference * num);
            maxElement = Math.max(maxElement, num);
            maxDifference = Math.max(maxDifference, Math.abs(maxElement - num));
        }
        return ans;
    }

    public static void main(String[] args) {
        var obj = new MaximumTripletValue_2873();

        int[] nums = {1, 10, 3, 4, 19};
        System.out.println(obj.maximumTripletValue3(nums));
    }
}