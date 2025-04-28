package _16_stack_queue.easy;

import java.util.ArrayDeque;

class RemoveDuplicates_1047 {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }

    public String removeDuplicates2(final String S) {
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            int n = sb.length();
            if (n > 0 && sb.charAt(n - 1) == c)
                sb.deleteCharAt(n - 1);
            else sb.append(c);
        }
        return sb.toString();
    }
}