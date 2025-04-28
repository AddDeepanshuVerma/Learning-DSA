package _10_Recursion.algo2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DeleteMiddleNodeStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        for (Integer next : stack) {
            System.out.print(next + " ");
        }
        deleteMiddleNode(stack, stack.size() >>> 1);
        System.out.println();
        for (Integer next : stack) {
            System.out.print(next + " ");
        }
    }

    private static void deleteMiddleNode(ArrayDeque<Integer> stack, int k) {
        if (k == 0) {
            stack.pop();
            return;
        }
        int pop = stack.pop();
        deleteMiddleNode(stack, --k);
        stack.push(pop);
    }
}
