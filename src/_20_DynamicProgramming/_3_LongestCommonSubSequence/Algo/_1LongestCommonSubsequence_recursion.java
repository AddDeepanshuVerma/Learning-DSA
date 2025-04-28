package _20_DynamicProgramming._3_LongestCommonSubSequence.Algo;

class _1LongestCommonSubsequence_recursion {
    public int longestCommonSubsequence(String text1, String text2) {
        return solve(text1, text2, 0, 0);
    }

    private int solve(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        int res = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            res = Math.max(res, 1 + solve(text1, text2, i + 1, j + 1));
        } else {
            res = Math.max(res, solve(text1, text2, i + 1, j));
            res = Math.max(res, solve(text1, text2, i, j + 1));
        }
        return res;
    }
}