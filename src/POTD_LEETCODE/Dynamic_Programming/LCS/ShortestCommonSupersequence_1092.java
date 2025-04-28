package POTD_LEETCODE.Dynamic_Programming.LCS;

class ShortestCommonSupersequence_1092 {
    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(shortestCommonSupersequence(s1, s2));
    }

    public static String shortestCommonSupersequence(String s1, String s2) {
        // first create the longest common subsequence matrix
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Backtrack to construct the Shortest Common SuperSequence (SCS)
        StringBuilder ans = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s1.charAt(i - 1));
                i--;
            } else {
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters from either string
        while (i > 0) ans.append(s1.charAt(i-- - 1));
        while (j > 0) ans.append(s2.charAt(j-- - 1));

        // Step 3: Reverse the string since we built it backwards
        return ans.reverse().toString();
    }
}