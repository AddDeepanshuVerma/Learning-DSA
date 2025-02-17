package _20_DynamicProgramming._3_LongestCommonSubSequence.Algo;

public class _4LongestCommonSubString_recursion {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("ABCDGH", "ACDGHR"));
    }

    /* Explanation:
     * Longest common substring & subSequence
     * 1. BruteForce : Take all substring out for s1 and s2 then compare all n^2 to m^2 substring for max length
     *                 Here TC would be n^2 * m^2 * n = n^5 ;(here last n is for equals comparison)
     * 2. Average    : Common substring would be the longest suffix possible bw comparison of all prefixes of s1 & s2.
     *                 means : make a matrix bw (all prefixes of s1 BY all prefixes of s2) not fill the matrix with their
     *                         suffixes (last character same) , the longest will be the answer which can lie anywhere in matrix
     * 3. Optimal    : From average we progress to this tabular approach here instead of creating the matrix bw prefixes, we
     *                 make using size of string where each incremented row represents the increment of character 1by1.
     *                 now here if row's & col's character are same we add 1 to it's (row-1)(col-1) AND if it not equal
     *                 we simply put 0 in there.
     *                 Also, that's the reason we don't get our optimal answer at the bottom-right but somewhere within the
     *                 matrix as subsequence ends at the end of string while subString may end someWhere between the String.
     * */

    static int max;

    public static int longestCommonSubstr(String s1, String s2) {
        max = 0;
        solve(s1, s2, s1.length(), s2.length());
        return max;
    }

    private static int solve(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) return 0;

        int ans = 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            ans = 1 + solve(s1, s2, i - 1, j - 1);
        } else {
            ans = 0;
        }

        solve(s1, s2, i - 1, j);
        solve(s1, s2, i, j - 1);

        max = Math.max(ans, max);
        return ans;
    }
}
