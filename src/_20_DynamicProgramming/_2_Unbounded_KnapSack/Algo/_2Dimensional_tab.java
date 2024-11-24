package _20_DynamicProgramming._2_Unbounded_KnapSack.Algo;

import java.util.Arrays;

public class _2Dimensional_tab {
    public static void main(String[] args) {
//        int[] nums2 = {1, 3, 3, 2};
//        System.out.println(solve(nums2, 3));
        int[] nums1 = {1, 2, 3};
        System.out.println(solve(nums1, 5));
        // the number of subset whose sum would be equal to 4 are :
        // {1,1,1}, {1,1,2}, {3}, {3}
    }

    // here what is being said is : we can take any index any number of times
    public static int solve(int[] arr, int sum) {
        int[][] t = new int[arr.length + 1][sum + 1];

        for (int row = 0; row < arr.length + 1; row++) {
            t[row][0] = 1;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int exclude = t[i - 1][j];

                int include = 0;
                if (j >= arr[i - 1]) include = t[i][j - arr[i - 1]]; // changes are here

                t[i][j] = exclude + include;
            }
        }
        for (int[] ints : t) {
            System.out.println(Arrays.toString(ints));
        }
        return t[arr.length][sum];
    }
}
