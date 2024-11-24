package _20_DynamicProgramming._1_01_KnapSack.Algo;

import java.util.Arrays;

public class _00_2Dimensional_tab {
    public static void main(String[] args) {
        int[] nums2 = {1, 3, 3, 2, 1};
        System.out.println(solve(nums2, 7));
    }


    public static int solve(int[] arr, int sum) {
        int[][] t = new int[arr.length + 1][sum + 1];

        for (int row = 0; row < arr.length + 1; row++) {
            t[row][0] = 1;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int exclude = t[i - 1][j];

                int include = 0;
                if (j >= arr[i - 1]) include = t[i - 1][j - arr[i - 1]];

                t[i][j] = exclude + include;
            }
        }
        for (int[] ints : t) {
            System.out.println(Arrays.toString(ints));
        }
        return t[arr.length][sum];
    }
}
