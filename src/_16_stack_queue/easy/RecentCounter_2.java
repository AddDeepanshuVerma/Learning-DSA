package _16_stack_queue.easy;

import java.util.ArrayDeque;

class RecentCounter_2 {
    ArrayDeque<Integer> queue;
    int size;

    public RecentCounter_2() {
        queue = new ArrayDeque<>();
        size = 0;
    }

    public int ping(int t) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Integer removed = queue.removeFirst();
            if ((t - 3000) <= removed && removed <= t) {
                count++;
                queue.addLast(removed);
            }
        }
        queue.addLast(t);
        return size = ++count;
    }
}