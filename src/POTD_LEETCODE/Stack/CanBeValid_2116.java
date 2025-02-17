package POTD_LEETCODE.Stack;

import java.util.ArrayDeque;

class CanBeValid_2116 {
    public static void main(String[] args) {
        String s = "())()))()(()(((())(()()))))((((()())(())";
        System.out.println(canBeValid(s, "1011101100010001001011000000110010100101"));
    }

    public static boolean canBeValid(String s, String locked) {
        int n = s.length();
        if ((n & 1) == 1)
            return false;

        ArrayDeque<Integer> stack = new ArrayDeque<>(), unlocked = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (locked.charAt(i) == '0')
                unlocked.push(i);
            else if (ch == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else if (!unlocked.isEmpty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }
        while (!stack.isEmpty() && !unlocked.isEmpty() && stack.peek() < unlocked.peek()) {
            stack.pop();
            unlocked.pop();
        }
        return stack.isEmpty();
    }
}


