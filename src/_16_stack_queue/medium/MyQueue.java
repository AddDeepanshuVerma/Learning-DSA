package _16_stack_queue.medium;

import java.util.ArrayDeque;

class MyQueue {
    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> reversal_stack;

    public MyQueue() {
        stack = new ArrayDeque<>();
        reversal_stack = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!reversal_stack.isEmpty()) {
            stack.push(reversal_stack.pop());
        }
        stack.push(x);
        while (!stack.isEmpty()) {
            reversal_stack.push(stack.pop());
        }
    }

    public int pop() {
        return reversal_stack.pop();
    }

    public int peek() {
        return reversal_stack.isEmpty() ? -1 : reversal_stack.peek();
    }

    public boolean empty() {
        return reversal_stack.isEmpty();
    }
}