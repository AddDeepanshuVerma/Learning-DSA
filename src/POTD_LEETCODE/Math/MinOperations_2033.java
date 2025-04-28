package POTD_LEETCODE.Math;

import java.util.Arrays;

class MinOperations_2033 {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length, k = 0;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        int target = arr[arr.length / 2];

        int count = 0;
        for (int val : arr) {
            int diff = Math.abs(val - target);
            if ((diff % x) > 0) return -1;
            count += (diff / x);
        }
        return count;
    }
}