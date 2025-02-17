package POTD_LEETCODE.Stack;

import java.util.ArrayDeque;

class CheckValidString_678 {
    public boolean checkValidString(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> star = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                star.push(i);
            } else if (ch == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!stack.isEmpty() && !star.isEmpty() && stack.peek() < star.peek()) {
            stack.pop();
            star.pop();
        }
        return stack.isEmpty();
    }
}