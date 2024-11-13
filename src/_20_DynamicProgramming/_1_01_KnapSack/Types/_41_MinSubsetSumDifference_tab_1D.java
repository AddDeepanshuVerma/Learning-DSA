package _20_DynamicProgramming._1_01_KnapSack.Types;

import java.util.Arrays;

public class _41_MinSubsetSumDifference_tab_1D {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 8};
        System.out.println(minSubsetSumDifference(arr, 5));
    }

    public static int minSubsetSumDifference(int[] arr, int n) {
        /*
         * Take the sum of array, find the sum/2 = mid now create a 2D tabulation array which store
         * all possible subset from 0 till mid marked as true now get the true value for max sum(column index) &
         * answer would be subset1 = max, subset2 = TotalSum - max ; Hence answer = abs(subset2-subset1)
         * */
        int totalSum = Arrays.stream(arr).sum();
        int mid = totalSum >> 1;

        boolean[] t = subsetSum(arr, mid);
        for (int sum = mid; sum >= 0; sum--) {
            if (t[sum]) return Math.abs((totalSum - sum) - sum);
        }
        return -1;
    }

    private static boolean[] subsetSum(int[] arr, int target) {
        boolean[] t = new boolean[target + 1];

        t[0] = true;

        for (int i = 0; i < arr.length; i++) {
            for (int sum = target; sum >= arr[i]; sum--) {
                t[sum] |= t[sum - arr[i]];
            }
        }

        return t;
    }

    private static boolean[] subsetSum2(int[] arr, int target) {
        boolean[] t = new boolean[target + 1];

        t[0] = true;

        for (int i = 0; i < arr.length; i++) {
            for (int sum = target; sum >= 0; sum--) {
                if (arr[i] <= sum) t[sum] |= t[sum - arr[i]];
            }
        }

        return t;
    }
}