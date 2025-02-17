package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

import java.util.Arrays;

public class _2Palindrome_partition_memoize {
    //Given a string s, partition s such that every substring of the partition is a palindrome.
    //Return the minimum cuts needed for a palindrome partitioning of s.
    public static void main(String[] args) {
        String s = "aaa";
        int minimumCuts = palindromePartition(s);
        System.out.println("minimumCuts = " + minimumCuts);
    }

    private static int palindromePartition(String s) {
        int n = s.length(), i = 0, j = n - 1;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        return dfs(i, j, s, dp);
    }

    private static int dfs(int i, int j, String s, int[][] dp) {
        if (i >= j || isPalindrome(i, j, s)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = dfs(i, k, s, dp), right = dfs(k + 1, j, s, dp);
            min = Math.min(min, left + right + 1);
        }
        return dp[i][j] = min;
    }

    private static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
