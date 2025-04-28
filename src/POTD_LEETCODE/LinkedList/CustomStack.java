package POTD_LEETCODE.LinkedList;

class CustomStack {
    private final int[] stack;
    private int end;
    private static final int DEFAULT_MAX_SIZE = 10;

    public CustomStack() {
        this(DEFAULT_MAX_SIZE);
    }

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        end = -1;
    }

    public void push(int x) {
        if (end == stack.length - 1) return; // stack is full
        stack[++end] = x;
    }

    public int pop() {
        if (end == -1) return -1;
        return stack[end--];
    }

    public void increment(int k, int val) {
        k = Math.min(end + 1, k);
        for (int i = 0; i < k; i++) stack[i] += val;
    }
}