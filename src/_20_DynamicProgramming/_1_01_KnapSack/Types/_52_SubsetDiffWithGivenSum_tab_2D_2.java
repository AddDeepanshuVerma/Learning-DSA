package _20_DynamicProgramming._1_01_KnapSack.Types;

import jdk.jfr.Description;

class _52_SubsetDiffWithGivenSum_tab_2D_2 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 2, 1};
        System.out.println(countPartitions(5, 5, arr));
    }

    @Description("Method 1 : Here we will so some calculations first then check specific solution ")
    public static int countPartitions(int n, int d, int[] arr) {
        /*
         * as per the math we have totalSum, difference hence a subset sum for given difference would be :
         *      subSet1_Sum - subSet2_Sum = diff
         *      subSet1_Sum - (totalSum - subSet1_Sum) = diff
         *      2 * subSet1_Sum = diff + totalSum
         *      subSet1_Sum = (diff + totalSum) / 2
         * hence we need to find the count of those subSets whose sum would be (diff + totalSum) / 2
         * */

        int totalSum = 0;
        for (int num : arr) totalSum += num;

        if (((d + totalSum) & 1) == 1) return 0; // if it's not even both Subset combined not equal to whole array

        int target = (d + totalSum) >> 1;
        return countOfSubsetSum(arr, target);
    }

    private static int countOfSubsetSum(int[] arr, int target) {
        int[][] t = new int[arr.length + 1][target + 1];

        for (int row = 0; row < arr.length + 1; row++) t[row][0] = 1;

        for (int i = 1; i < arr.length + 1; i++) {
            for (int sum = 0; sum < target + 1; sum++) {
                int exclude = t[i - 1][sum];
                int include = 0;
                if (arr[i - 1] <= sum) {
                    include = t[i - 1][sum - arr[i - 1]];
                }

                t[i][sum] = (exclude + include) % 1000_000_007;
            }
        }
        return t[arr.length][target];
    }
}