package _10_Recursion.algo2;

import java.util.ArrayDeque;
import java.util.List;

public class ReverseStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(List.of(1, 2, 3, 4, 5, 6, 7));
        for (Integer next : stack) System.out.print(next + " ");
        reverse(stack);System.out.println();
        for (Integer next : stack) System.out.print(next + " ");
    }

    private static void reverse(ArrayDeque<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        int pop = stack.pop();
        reverse(stack);
        insertAtBack(stack, pop);
    }

    private static void insertAtBack(ArrayDeque<Integer> stack, int pop) {
        if (stack.isEmpty()) {
            stack.push(pop);
            return;
        }
        int newPop = stack.pop();
        insertAtBack(stack, pop);
        stack.push(newPop);
    }
}
