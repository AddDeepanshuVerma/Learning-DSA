package _20_DynamicProgramming._1_01_KnapSack.Types;

import java.util.Arrays;

class _13_SubsetSum_tab {
    public static void main(String[] args) {
        int[] nums = {8, 9, 9};
        System.out.println(isSubsetSum3(nums, 6));

    }

    // taking tabulation array as [n][target + 1]
    static Boolean isSubsetSum(int[] arr, int target) {
        boolean[][] t = new boolean[arr.length][target + 1];
        // fill the first row as a base case condition
        t[0][0] = true;
        for (int sum = 1; sum < target + 1; sum++) { // must put first row correct
            if (sum == arr[0]) t[0][sum] = true;
        }

        for (int i = 1; i < t.length; i++) {
            for (int sum = 0; sum < target + 1; sum++) {
                // do not include
                boolean exclude = t[i - 1][sum];

                // include
                boolean include = false;
                if (arr[i] <= sum) include = t[i - 1][sum - arr[i]];

                t[i][sum] = include || exclude;
            }
        }
        Arrays.stream(t).map(Arrays::toString).forEach(System.out::println);
        return t[arr.length - 1][target];
    }

    static Boolean isSubsetSum2(int[] arr, int target) {
        boolean[][] t = new boolean[arr.length][target + 1];

        t[0][0] = true;
        for (int sum = 1; sum < target + 1; sum++) {
            if (sum == arr[0]) t[0][sum] = true;
        }

        for (int i = 1; i < t.length; i++) {
            for (int sum = 0; sum < target + 1; sum++) {
                boolean res = t[i - 1][sum];

                if (arr[i] <= sum) {
                    res = t[i - 1][sum - arr[i]] || res;
                }

                t[i][sum] = res;
            }
        }
        return t[arr.length - 1][target];
    }

    // taking tabulation array as [n + 1][target + 1]
    static Boolean isSubsetSum3(int[] arr, int target) {
        boolean[][] t = new boolean[arr.length + 1][target + 1];

        for (int row = 0; row < arr.length + 1; row++) {
            t[row][0] = true;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int sum = 0; sum < target + 1; sum++) { // can also start with sum == 1
                boolean exclude = t[i - 1][sum];

                boolean include = false;
                if (arr[i - 1] <= sum) include = t[i - 1][sum - arr[i - 1]];

                t[i][sum] = include || exclude;
            }
        }
        Arrays.stream(t).map(Arrays::toString).forEach(System.out::println);
        return t[arr.length][target];
    }
}