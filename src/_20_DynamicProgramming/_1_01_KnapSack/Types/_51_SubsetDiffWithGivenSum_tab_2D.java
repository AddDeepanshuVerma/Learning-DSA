package _20_DynamicProgramming._1_01_KnapSack.Types;

import jdk.jfr.Description;

class _51_SubsetDiffWithGivenSum_tab_2D {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        System.out.println(countPartitions(4, 3, arr));
    }

    @Description("Method 1 : Here we are calculating all count for all subset till totalSum/2")
    public static int countPartitions(int n, int d, int[] arr) {
        /*
         * create the 2D array of containing all possible subsets for [0, totalSum]
         * now for the last row where each colum represents given sum starting from [0, totalSum] :
         * get how many subset will have a difference of d
         * */

        int modulo = 1000_000_007;
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        int[][] t = subSetSum(arr, totalSum >> 1);
        int count = 0;
        for (int sum = totalSum >> 1; sum >= 0; sum--) {
            if (t[arr.length][sum] > 0) {
                int subSet1 = sum;
                int subSet2 = totalSum - subSet1;
                if (Math.abs(subSet2 - subSet1) == d) {
                    count = (count + t[arr.length][sum]) % modulo;
                }
            }
        }
        return count;
    }

    private static int[][] subSetSum(int[] arr, int target) {
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
        return t;
    }
}