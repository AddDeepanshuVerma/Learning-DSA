package _16_stack_queue.easy;

import jdk.jfr.Description;

import java.util.ArrayDeque;
import java.util.Stack;

class RemoveOuterParentheses_1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses2("(()(()))"));
    }

    /*Intuition : Primitive string will have equal number of opened and closed parenthesis
    Explanation : opened count the number of opened parenthesis
    Add every char to the result, unless the first left parenthesis
    and the last right parenthesis*/
    public static String removeOuterParentheses2(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }

    public static String removeOuterParentheses3(String s) {
        StringBuilder ans = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                ans.append((stack.size() > 1) ? c : "");
            } else if (c == ')') {
                stack.pop();
                ans.append(stack.isEmpty() ? "" : c);
            }
        }
        return ans.toString();
    }

    @Description("Wrong approach hence the result")
    public static String removeOuterParentheses(String s) {
        String ans = "";
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() == 1) {
                    stack.pop();
                } else {
                    ans = stack.pop() + ans + c;
                }
            }
        }
        return ans;
    }

}