package _16_stack_queue.easy;

import java.util.Set;
import java.util.Stack;

class IsValid_20 {
    public static void main(String[] args) {
        IsValid_20 obj = new IsValid_20();
        System.out.println(obj.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        final Set<Character> set = Set.of('(', '{', '[');
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else if (c == ')' && stack.peek() == '(') stack.pop();
                else if (c == '}' && stack.peek() == '{') stack.pop();
                else if (c == ']' && stack.peek() == '[') stack.pop();
                else stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        final Set<Character> set = Set.of('(', '{', '[');
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else if (c == ')' && stack.pop() != '(') return false;
                else if (c == '}' && stack.pop() != '{') return false;
                else if (c == ']' && stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}