package Recursion_10;

import java.util.List;
import java.util.Stack;

public class TBD {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(20);
        stack.push(20);
        stack.push(5);
        stack.push(9);
        stack.push(4);
        stack.push(7);
        sortStack(stack);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    private static void sortStack(Stack<Integer> stack) {
        if (stack.size() == 1) return;
        Integer pop = stack.pop();
        sortStack(stack);
        insertStack(stack, pop);
    }

    private static void insertStack(Stack<Integer> stack, Integer temp) {
        if (stack.isEmpty() || stack.peek() >= temp) {
            stack.push(temp);
            return;
        }
        Integer val = stack.pop();
        insertStack(stack, temp);
        stack.push(val);
    }
}