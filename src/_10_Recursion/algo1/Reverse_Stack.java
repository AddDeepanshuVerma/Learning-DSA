package _10_Recursion.algo1;

import java.util.Stack;

public class Reverse_Stack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(9);
        stack.push(3);
        stack.push(0);
        reverse(stack);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        Integer pop = stack.pop();
        reverse(stack);
        insertStack(stack, pop);
    }

    private static void insertStack(Stack<Integer> stack, Integer pop) {
        if (stack.isEmpty()) {
            stack.push(pop);
            return;
        }
        Integer val = stack.pop();
        insertStack(stack, pop);
        stack.push(val);
    }


    private static void ReverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        stack.push(stack.pop());
        ReverseStack(stack);
    }
}
