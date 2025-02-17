package _20_DynamicProgramming._4_PalindromicSubSequences.Types;

class _0_LongestPalindromeSubseq_memoiz {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        return dfs(s, 0, n - 1, dp);
    }

    public static int dfs(String s, int start, int end, int[][] dp) {
        if (start == end) return 1;
        if (start > end) return 0;

        if (dp[start][end] != 0) return dp[start][end];

        int length = 0;
        if (s.charAt(start) == s.charAt(end)) {
            length = 2 + dfs(s, start + 1, end - 1, dp);
        } else {
            length = Math.max(dfs(s, start + 1, end, dp), dfs(s, start, end - 1, dp));
        }

        return dp[start][end] = length;
    }
}