package POTD_LEETCODE.Monotonic_Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

class ParseBoolExpr_1106 {
    public boolean parseBoolExpr(String expression) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] arr = expression.toCharArray();
        for (char ch : arr) {
            switch (ch) {
                case ')' -> {
                    ArrayList<Character> list = new ArrayList<>();
                    while (!stack.isEmpty() && stack.peekFirst() != '(') {
                        list.add(stack.pop());
                    }
                    stack.pop(); // popping '(' from top
                    Character operator = stack.pop(); // either OR & !
                    char temp = calculate(list, operator);
                    stack.addFirst(temp);
                }
                case ',' -> {
                }
                default -> {
                    stack.addFirst(ch);
                }
            }
        }
        return !stack.isEmpty() && stack.peekFirst() == 't';
    }

    private char calculate(ArrayList<Character> list, Character operator) {
        switch (operator) {
            case '!' -> {
                return list.getFirst() == 't' ? 'f' : 't';
            }
            case '&' -> {
                for (Character c : list) {
                    if (c == 'f') return 'f';
                }
                return 't';
            }
            case '|' -> {
                for (Character c : list) {
                    if (c == 't') return 't';
                }
                return 'f';
            }
        }
        return 't';// will not be executed ever
    }

}