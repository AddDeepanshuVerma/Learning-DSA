package _10_Recursion.algo1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LetterCasePermutation_784_3 {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        LetterCasePermutation_784_3 obj = new LetterCasePermutation_784_3();
        System.out.println(obj.letterCasePermutation("3z4"));
    }

    public static List<String> letterCasePermutation(String str) {
        print("", str);
        List<String> list = new ArrayList<>(set);
        set.clear();
        return list;
    }

    private static void print(String op, String ip) {
        if (ip.isEmpty()) {
            set.add(op);
            return;
        }
        print(op + Character.toLowerCase(ip.charAt(0)), ip.substring(1));
        print(op + Character.toUpperCase(ip.charAt(0)), ip.substring(1));
    }
}