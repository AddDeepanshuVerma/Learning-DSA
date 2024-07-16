package _10_Recursion;

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation_784_2 {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String str = "3z4";
        System.out.println(letterCasePermutation(str));
    }

    public static List<String> letterCasePermutation(String s) {
        print("", s);
        return list.stream().distinct().toList();
    }

    private static void print(String op, String ip) {
        if (ip.isEmpty()) {
            list.add(op);
            return;
        }
        print(op + Character.toLowerCase(ip.charAt(0)), ip.substring(1));
        print(op + Character.toUpperCase(ip.charAt(0)), ip.substring(1));
    }
}