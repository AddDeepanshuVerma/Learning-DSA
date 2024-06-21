package Strings.easy;

import java.util.Stack;

class IsValid_20 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValid3(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            boolean flag = checkIfEqual(s.charAt(i), s.charAt(n - i - 1));
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfEqual(char c, char c1) {
        return (c + 1) == (c1);
    }
}