package _16_stack_queue.medium;

class CustomStack {
    private final int[] stack;
    private int end;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        end = 0;
    }

    public void push(int x) {
        if (end == stack.length) return;
        stack[end] = x;
        end++;
    }

    public int pop() {
        if (end == 0) return -1;
        else return stack[--end];
    }

    public void increment(int k, int val) {
        k = Math.min(k, stack.length);
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}
