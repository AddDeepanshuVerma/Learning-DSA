package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

class _11ScrambleString_memoization_87_copied {
    /*
    s1, s2 is scramble when
        s1[0:k], s2[0:k] is scramble and s1[k:n], s2[k:n] is scramble.
    Or,
        s1[0:k], s2[n-k:n] is scramble and s1[k:n], s2[0:n-k] is scramble.
    */
    
    public boolean isScramble(String s1, String s2) {
        Boolean[][][] memo = new Boolean[s1.length()][s2.length()][s1.length() + 1];
        return helper(s1, s2, 0, 0, s1.length(), memo);
    }

    public boolean helper(String s1, String s2, int i, int j, int len, Boolean[][][] memo) {
        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }
        if (len == 1) {
            return memo[i][j][len] = s1.charAt(i) == s2.charAt(j);
        }
        // try every length
        for (int k = 1; k < len; k++) {
            if (helper(s1, s2, i, j, k, memo) && helper(s1, s2, i + k, j + k, len - k, memo)) {
                return memo[i][j][len] = true;
            }
            if (helper(s1, s2, i, j + len - k, k, memo) && helper(s1, s2, i + k, j, len - k, memo)) {
                return memo[i][j][len] = true;
            }
        }
        return memo[i][j][len] = false;
    }
} 