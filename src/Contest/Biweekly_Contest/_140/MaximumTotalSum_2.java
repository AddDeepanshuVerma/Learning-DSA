package Contest.Biweekly_Contest._140;

import java.util.Arrays;

class MaximumTotalSum_2 {
    public long maximumTotalSum(int[] arr) {
        long ans = 0;
        Arrays.sort(arr);
        int n = arr.length;
        ans = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            if (arr[j] >= arr[j + 1]) {
                arr[j] = arr[j + 1] - 1;
            }
            if (arr[j] <= 0) {
                return -1;
            }
            ans += arr[j];
        }
        return ans;
    }
}