package _16_stack_queue.easy;

import java.util.ArrayDeque;

class RecentCounter {
    ArrayDeque<Integer> queue;
    int size;

    public RecentCounter() {
        queue = new ArrayDeque<>();
        size = 0;
    }

    public int ping(int t) {
        queue.addLast(t);
        size++;
        int count = 0;
        for (int i = 0; i < size; i++) {
            Integer removed = queue.removeFirst();
            if ((t - 3000) <= removed && removed <= t) {
                count++;
                queue.addLast(removed);
            }
        }
        return size = count;
    }
}