package _10_Recursion.algo1;

import java.util.Stack;

public class DeleteElement_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);stack.push(2);
        stack.push(3);stack.push(4);
        stack.push(5);stack.push(6);
        deleteMidElement(stack);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    private static void deleteMidElement(Stack<Integer> stack) {
        int mid = (stack.size() >>> 1) + 1;
        deleteElement(stack, mid);
    }

    private static void deleteElement(Stack<Integer> stack, int mid) {
        if (mid == 1) {stack.pop(); return;}
        int temp = stack.pop();
        deleteElement(stack, mid - 1);
        stack.push(temp);
    }
}
