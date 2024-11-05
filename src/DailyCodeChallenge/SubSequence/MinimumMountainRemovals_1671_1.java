package DailyCodeChallenge.SubSequence;

import java.util.Arrays;

class MinimumMountainRemovals_1671_1 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n], lds = new int[n];
        Arrays.fill(lds, 1);
        Arrays.fill(lis, 1);

        // calculate each index LIS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        // calculate each index LDS
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], 1 + lds[j]);
                }
            }
        }

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