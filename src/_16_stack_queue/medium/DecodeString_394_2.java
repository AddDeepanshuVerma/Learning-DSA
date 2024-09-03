package _16_stack_queue.medium;

import java.util.ArrayDeque;
import java.util.Stack;

class DecodeString_394_2 {
    public static void main(String[] args) {
        DecodeString_394_2 o = new DecodeString_394_2();
        System.out.println(o.decodeString("abc"));
        System.out.println(o.decodeString("11[ab]"));
        System.out.println(o.decodeString("3"));
        System.out.println(o.decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<Integer> num = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ']') {
                if (Character.isDigit(arr[i])) {
                    int k = 0;
                    while (i < arr.length && Character.isDigit(arr[i])) {
                        k = k * 10 + (arr[i++] - '0');
                    }
                    i--;
                    num.push(k);
                } else stack.push(arr[i] + "");
            } else if (arr[i] == ']') {
                StringBuilder ans = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    ans.insert(0, stack.pop());
                }
                stack.pop();
                stack.push(repeat(ans.toString(), num.pop()));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }

    private String repeat(String ans, Integer times) {
        StringBuilder sb = new StringBuilder();
        while (times-- > 0) sb.append(ans);
        return sb.toString();
    }
}