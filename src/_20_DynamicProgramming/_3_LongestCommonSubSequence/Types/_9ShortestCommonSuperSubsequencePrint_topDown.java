package _20_DynamicProgramming._3_LongestCommonSubSequence.Types;

public class _9ShortestCommonSuperSubsequencePrint_topDown {
    public static void main(String[] args) {
//        String s1 = "AGGTAB", s2 = "GXTXAYB";
        String s1 = "bbabacaa", s2 = "cccababab";

        String lcs = longestCommonSubsequence(s1, s2);
        String scss = findShortestCommonSuperSequence(s1, s2, lcs);
        System.out.println("scss = " + scss);
    }

    private static String findShortestCommonSuperSequence(String s1, String s2, String lcs) {
        int i = 0, j = 0, k = 0;
        int m = s1.length(), n = s2.length(), o = lcs.length();
        StringBuilder ans = new StringBuilder();

        while (i < m && j < n && k < o) {
            if (s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == lcs.charAt(k)) {
                ans.append(s1.charAt(i));
                i++;
                j++;
                k++;
            } else if (s1.charAt(i) == lcs.charAt(k)) {
                ans.append(s2.charAt(j));
                j++;
            } else if (s2.charAt(j) == lcs.charAt(k)) {
                ans.append(s1.charAt(i));
                i++;
            } else {
                ans.append(s1.charAt(i));
                ans.append(s2.charAt(j));
                i++;
                j++;
            }
        }
        while (i < m) {
            ans.append(s1.charAt(i));
            i++;
        }
        while (j < n) {
            ans.append(s2.charAt(j));
            j++;
        }
        return ans.toString();
    }

    private static String longestCommonSubsequence(String s1, String s2) {
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
        // now get the String which is common in both
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return lcs.toString();
    }

}
