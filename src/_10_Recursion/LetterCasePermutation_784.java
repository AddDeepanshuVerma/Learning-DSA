package _10_Recursion;

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation_784 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "32222z4";
        print("", str, list);
        System.out.println(list);
    }

    private static void print(String op, String ip, List<String> list) {
        if (ip.isEmpty()) {
            list.add(op);
            return;
        }
        if (Character.isDigit(ip.charAt(0)))
            print(op + ip.charAt(0), ip.substring(1), list);
        else {
            print(op + Character.toLowerCase(ip.charAt(0)), ip.substring(1), list);
            print(op + Character.toUpperCase(ip.charAt(0)), ip.substring(1), list);
        }
    }
}