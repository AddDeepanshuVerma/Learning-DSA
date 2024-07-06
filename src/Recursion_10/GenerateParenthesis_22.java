package Recursion_10;

import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        getPrintedAllComb("", n, n, list);
        return list;
    }

    private static void getPrintedAllComb(String op, int open, int close, List<String> list) {
        if (open == 0 && close == 0) { list.add(op); return; }

        if (open != 0)
            getPrintedAllComb(op + "(", open - 1, close, list);
        if (close > open)
            getPrintedAllComb(op + ")", open, close - 1, list);
    }
}