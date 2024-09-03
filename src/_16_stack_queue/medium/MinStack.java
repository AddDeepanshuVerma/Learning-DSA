package _16_stack_queue.medium;

import java.util.Stack;

class MinStack {
    record Pair<K, V>(K key, V min) {
    } /*
    record Pair2(Integer key, Integer min) { }
    Stack<Pair2> stack2; */

    Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min;
        if (stack.isEmpty()) min = val;
        else min = Math.min(val, stack.peek().min());
        stack.push(new Pair<>(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().key();
    }

    public int getMin() {
        return stack.peek().min();
    }
}
