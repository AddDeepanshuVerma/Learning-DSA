package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("Still getting TLE as question demands to optimize more")
class _13SuperEggDrop_memoize_887 {
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
        for (int currFloor = 1; currFloor <= f; currFloor++) {
            int broke = dfs(e - 1, currFloor - 1, dp);
            int unBroke = dfs(e, f - currFloor, dp);
            min = Math.min(min, 1 + Math.max(unBroke, broke));
        }
        return dp[e][f] = min;
    }
}