package DailyCodeChallenge.SubSequence;

import java.util.Arrays;

class MinimumMountainRemovals_1671 {
    public static void main(String[] args) {
        MinimumMountainRemovals_1671 obj = new MinimumMountainRemovals_1671();
        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println("arr = " + Arrays.toString(nums));
        obj.minimumMountainRemovals(nums);
    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        // calculate each index LIS
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) lis[i] = Math.max(lis[i], 1 + lis[j]);
            }
        }
        System.out.println("lis = " + Arrays.toString(lis));

        // calculate each index LDS
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], 1 + lds[j]);
                }
            }
        }
        System.out.println("lds = " + Arrays.toString(lds));

        // now find max length of mountain array
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                maxLength = Math.max(maxLength, lis[i] + lds[i]);
            }
        }

        // remaining minimum would be n - max (peak on mountain was counted twice hence -1 )
        return n - (maxLength - 1);
    }
}