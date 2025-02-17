package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

import java.util.HashMap;

class _10ScrambleString_memoization_87 {
    public static void main(String[] args) {
        String s1 = "abcdbdacbdac", s2 = "bdacabcdbdac";
//        String s1 = "der", s2 = "red";
        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        HashMap<String, Boolean> dp = new HashMap<String, Boolean>();
        return dfs(s1, s2, dp);
    }

    private static boolean dfs(String src, String target, HashMap<String, Boolean> dp) {
        if (dp.containsKey(src + target)) {
            return dp.get(src + target);
        }

        if (src.length() != target.length()) return false;
        if (src.equals(target)) return true;
        if (src.length() == 1) return src.charAt(0) == target.charAt(0);

        boolean flag = false;
        int len = src.length();
        for (int k = 1; k < len; k++) {
            // separate the src string at the location and check
            // when both src and target are separated at this location, can they make be the potential candidate to check further
            String srcLeft = src.substring(0, k), srcRight = src.substring(k);
            String tarLeft = target.substring(0, k), tarRight = target.substring(k);
            String tarRightest = target.substring(len - k);
            String tarLeftest = target.substring(0, len - k);

            if (dfs(srcLeft, tarRightest, dp) && dfs(srcRight, tarLeftest, dp)) {
                flag = true;
                break;
            }
            if (dfs(srcLeft, tarLeft, dp) && dfs(srcRight, tarRight, dp)) {
                flag = true;
                break;
            }
        }
        dp.putIfAbsent(src + target, flag);
        return flag;
    }
}