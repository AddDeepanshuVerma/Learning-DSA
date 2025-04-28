package POTD_LEETCODE.level_3;

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation_784_3 {
    List<String> list;

    public static void main(String[] args) {
        LetterCasePermutation_784_2 obj = new LetterCasePermutation_784_2();
        System.out.println(obj.letterCasePermutation("a1b2"));
    }

    public List<String> letterCasePermutation(String s) {
        list = new ArrayList<>();
        String ip = s.toLowerCase();
        String op = "";
        DFS(op, ip);
        return list;
    }

    private void DFS(String op, String ip) {
        if (ip.isEmpty()) {
            list.add(op);
            return;
        }
        if (!Character.isAlphabetic(ip.charAt(0))) {
            DFS(op + ip.charAt(0), ip.substring(1));

        } else {
            // Take with capital alpha
            DFS(op + Character.toLowerCase(ip.charAt(0)), ip.substring(1));
            // Take with small alpha
            DFS(op + Character.toUpperCase(ip.charAt(0)), ip.substring(1));
        }

    }
}