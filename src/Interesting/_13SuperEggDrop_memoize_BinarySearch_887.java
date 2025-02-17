package Interesting;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("Still getting TLE as question demands to optimize more")
class _13SuperEggDrop_memoize_BinarySearch_887 {
    public static void main(String[] args) {
        int eggs = 3;
        int floor = 14;
        System.out.println(superEggDrop(eggs, floor));
    }

    public static int superEggDrop(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        return dfs(e, f, dp);
    }

    private static int dfs(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;
        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        int min = Integer.MAX_VALUE;
        int start = 1, end = f;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int left = dfs(e - 1, mid - 1, dp); // egg broke hence check mid-1 now
            int right = dfs(e, f - mid, dp);      // egg not broke hence check remaining floors

            min = Math.min(min, 1 + Math.max(left, right));

            if (left <= right) { // higher possibles lies on right side hence more right
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return dp[e][f] = min;
    }
}