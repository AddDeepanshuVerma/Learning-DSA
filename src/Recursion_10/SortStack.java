package Recursion_10;

import Binary_Search_on_answers.Templet;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);stack.push(2);
        stack.push(3);stack.push(4);
        stack.push(5);stack.push(6);
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


    private static void insertStack(Stack<Integer> stack, int pop) {
        if (stack.isEmpty() || stack.peek() >= pop) {stack.push(pop);return;}
        Integer value = stack.pop();
        insertStack(stack, pop);
        stack.push(value);
    }
}
