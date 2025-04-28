package _08_Strings.medium;

import java.util.Stack;

class Calculate_227 {
    public static void main(String[] args) {
        if (false && true || false) {
            System.out.println("hi");
        }
        System.out.println(calculate2(" 3 / 2 "));
    }

    public static int calculate(String s) {
        char prevOperator = '+';
        int currNumber = 0;
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (Character.isDigit(ch)) {
                currNumber = currNumber * 10 + (ch - '0');
            }
            if (isOperator(ch) || i == arr.length - 1) {
                switch (prevOperator) {
                    case '+' -> stack.push(currNumber);
                    case '-' -> stack.push(-currNumber);
                    case '*' -> stack.push(stack.pop() * currNumber);
                    case '/' -> stack.push(stack.pop() / currNumber);
                }
                prevOperator = ch;
                currNumber = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }

    public static int calculate2(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}