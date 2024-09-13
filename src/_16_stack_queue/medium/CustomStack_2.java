package _16_stack_queue.medium;

class CustomStack_2 {
    private final int[] stack;
    private int end;

    public CustomStack_2(int maxSize) {
        stack = new int[maxSize];
        end = -1;
    }

    public void push(int x) {
        if (end == stack.length - 1) return;
        stack[++end] = x;
    }

    public int pop() {
        if (end == -1) return -1;
        else return stack[end--];
    }

    public void increment(int k, int val) {
        k = Math.min(k, stack.length);
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}
