package _20_DynamicProgramming.LeetCode.hard;

import java.util.Arrays;

// Not Yet solved
class MinTravelTime_3538_2 {

    private static int[][][] dp;

    public static int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        int idx = 1, prevIdx = 0, offSet = 0;
        dp = new int[n + 1][n + 1][k + 1];
        for (int[][] arr : dp) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }
        return dfs(idx, prevIdx, position, time, k, n);
    }

    private static int dfs(int i, int prevIdx, int[] position, int[] time, int k, int n) {
        int delta = (position[i] - position[prevIdx]) * (time[prevIdx]);
        if (i == n - 1) {
            return k == 0 ? delta : Integer.MAX_VALUE >> 1;
        }

        if (dp[i][prevIdx][k] != -1) {
            return dp[i][prevIdx][k];
        }

        int pick = delta + dfs(i + 1, i, position, time, k, n);
        int notPick = Integer.MAX_VALUE;
        if (k > 0) {
            time[i + 1] += time[i];
            notPick = dfs(i + 1, prevIdx, position, time, k - 1, n);
            time[i + 1] -= time[i];
        }

        return dp[i][prevIdx][k] = Math.min(pick, notPick);
    }

    public static void main(String[] args) {
        int l = 5, n = 5, k = 1;
        int[] position = {0, 1, 2, 3, 5}, time = {8, 3, 9, 3, 3};

        int ans = minTravelTime(l, n, k, position, time);
        System.out.println("ans = " + ans);
    }
}