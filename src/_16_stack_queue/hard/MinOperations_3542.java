package _16_stack_queue.hard;

import java.util.ArrayDeque;

class MinOperations_3542 {
    public int minOperations(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int operations = 0;

        for (int num : nums) {
            if (num == 0) {
                stack.clear();
                continue;
            }
            if (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < num) {
                stack.push(num);
                operations++;
            }
        }
        return operations;
    }
}