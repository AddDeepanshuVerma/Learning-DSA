package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayDeque;
import java.util.Stack;

class DecodeString_394_3 {
    public static void main(String[] args) {
        DecodeString_394_3 o = new DecodeString_394_3();
        System.out.println(o.decodeString("abc"));
        System.out.println(o.decodeString("11[ab]"));
        System.out.println(o.decodeString("3"));
        System.out.println(o.decodeString("3[a]2[bc]"));
    }

    @Description("_2 is better and understandable")
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> stack = new Stack<>();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
                continue;
            }
            if (c == '[') {
                num.push(k);
                stack.push(String.valueOf(c));
                k = 0;
                continue;
            }
            if (c != ']') {
                stack.push(String.valueOf(c));
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while (!stack.peek().equals("[")) temp.insert(0, stack.pop());

            // remove the "["
            stack.pop();
            StringBuilder replacement = new StringBuilder();
            int count = num.pop();
            for (int i = 0; i < count; i++)
                replacement.append(temp);

            // Add it to the stack
            stack.push(replacement.toString());
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}