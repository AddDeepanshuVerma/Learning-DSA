package _20_DynamicProgramming._5_MatrixChainMultiplication.Types;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;

class _8ScrambleString_recursion_87 {
    @Description("Way higher TC, does not work at all")
    public static void main(String[] args) {
        String s1 = "great", s2 = "rgeat";
//        String s1 = "abcdbdacbdac", s2 = "bdacabcdbdac";
        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n <= 1) return true;
        List<String> combo = dfs(0, n - 1, s1);
        System.out.println("combo = " + combo);
        return combo.contains(s2);
    }

    private static List<String> dfs(int i, int j, String s1) {
        if (i > j) return List.of();
        if (i == j) {
            return List.of(String.valueOf(s1.charAt(i)));
        }

        List<String> combos = new ArrayList<>();
        for (int k = i; k < j; k++) {
            List<String> left = dfs(i, k, s1), right = dfs(k + 1, j, s1);
            for (String l : left) {
                for (String r : right) {
                    combos.add(l + r);
                    combos.add(r + l);
                }
            }
        }
        return combos;
    }
}