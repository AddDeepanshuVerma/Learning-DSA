package _20_DynamicProgramming._1_01_KnapSack.Types;

public class _41_MinSubsetSumDifference_tab_2D {
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
        int totalSum = 0;
        for (int j : arr) totalSum += j;
        int mid = totalSum >> 1;

        boolean[][] t = subsetSum(arr, mid);
        for (int sum = mid; sum >= 0; sum--) {
            if (t[arr.length][sum]) {
                return Math.abs((totalSum - sum) - sum);
            }
        }
        return -1;
    }

    private static boolean[][] subsetSum(int[] arr, int target) {
        boolean[][] t = new boolean[arr.length + 1][target + 1];

        for (int row = 0; row < arr.length + 1; row++) {
            t[row][0] = true;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int sum = 0; sum < target + 1; sum++) {
                boolean exclude = t[i - 1][sum];

                boolean include = false;
                if (arr[i - 1] <= sum) include = t[i - 1][sum - arr[i - 1]];

                t[i][sum] = exclude || include;
            }
        }
        return t;
    }
}