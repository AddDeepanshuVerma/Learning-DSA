package _20_DynamicProgramming._4_PalindromicSubSequences.leetcode;

class MinInsertions_1312_memoization {
    //Minimum number Insertion to Make a String Palindrome
    public int minInsertions(String s) {
        // step 1: find the longest common palindrome subsequence already present in string
        int len = LongestPalindromeSubseq(s);

        // step 2: rest character which are not included in LPS needs to be inserted
        return s.length() - len;    // insertion
    }

    private static int LongestPalindromeSubseq(String str) {
        int m = str.length(), left = 0, right = m - 1;
        int[][] dp = new int[m + 1][m + 1];
        return dfs(str, left, right, dp);
    }

    private static int dfs(String str, int left, int right, int[][] dp) {
        if (left == right || left > right) return left == right ? 1 : 0;

        if (dp[left][right] != 0) return dp[left][right];

        if (str.charAt(left) == str.charAt(right)) {
            return dp[left][right] = 2 + dfs(str, left + 1, right - 1, dp);
        } else {
            return dp[left][right] = Math.max(dfs(str, left + 1, right, dp), dfs(str, left, right - 1, dp));
        }
    }
}