package _10_Recursion.algo2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class sortStack_recusrionOnly {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(5, 4, 3, 2, 1, 6, 5, 4, 3));
        sortStack(stack);
        for (Iterator<Integer> iterator = stack.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            System.out.print(next + " ");
        }
    }

    private static void sortStack(ArrayDeque<Integer> stack) {
        if (stack.size() == 1) return;
        int pop = stack.pop();
        sortStack(stack);
        insert(stack, pop);
    }

    private static void insert(ArrayDeque<Integer> stack, int pop) {
        if (stack.isEmpty() || stack.peekFirst() >= pop) {
            stack.push(pop);
            return;
        }
        int newPop = stack.pop();
        insert(stack, pop);
        stack.push(newPop);
    }
}
