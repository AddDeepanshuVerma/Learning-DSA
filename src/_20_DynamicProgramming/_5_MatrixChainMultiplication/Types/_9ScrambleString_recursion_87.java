package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

class _9ScrambleString_recursion_87 {
    public static void main(String[] args) {
        String s1 = "abcdbdacbdac", s2 = "bdacabcdbdac";
        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        return dfs(s1, s2);
    }

    private static boolean dfs(String src, String target) {
        if (src.length() != target.length()) return false;
        if (src.equals(target)) return true;
//        if (src.length() == 1) return src.charAt(0) == target.charAt(0);
        if (src.length() == 1) return false;

        boolean flag = false;
        int len = src.length();
        for (int k = 1; k < len; k++) {
            // separate the src string at the location and check
            // when both src and target are separated at this location, can they make be the potential candidate to check further
            if (dfs(src.substring(0, k), target.substring(len - k)) && dfs(src.substring(k), target.substring(0, len - k))) {
                flag = true;
                break;
            }
            if (dfs(src.substring(0, k), target.substring(0, k)) && dfs(src.substring(k), target.substring(k))) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}