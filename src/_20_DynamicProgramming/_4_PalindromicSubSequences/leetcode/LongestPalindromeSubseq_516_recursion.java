package _20_DynamicProgramming._4_PalindromicSubSequences.leetcode;

public class LongestPalindromeSubseq_516_recursion {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.out.println(longestPalindromeSubseq(s));
    }

    private static int longestPalindromeSubseq(String s) {
        return dfs(s, 0, s.length() - 1);
    }

    private static int dfs(String s, int left, int right) {
        if (left == right) return 1;

        if (left > right) return 0;

        if (s.charAt(left) == s.charAt(right)) {
            return 2 + dfs(s, left + 1, right - 1);
        } else {
            return Math.max(dfs(s, left + 1, right), dfs(s, left, right - 1));
        }
    }
}
