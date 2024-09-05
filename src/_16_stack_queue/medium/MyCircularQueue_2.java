package _16_stack_queue.medium;

class MyCircularQueue_2 {
    protected int[] queue;
    protected int front;
    protected int end;
    private int size;
    private final int k; //queue size

    public MyCircularQueue_2(int k) {
        this.k = k;
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[end++] = value;
        end = end % k;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = ++front % k;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[((end - 1) + k) % k];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}

/*
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */