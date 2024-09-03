package _16_stack_queue.easy;

import java.util.ArrayDeque;

class RecentCounter_3 {
    ArrayDeque<Integer> queue;

    public RecentCounter_3() {
        queue = new ArrayDeque<>();
    }

    public int ping2(int t) {
        queue.addLast(t);
        while (queue.peekFirst() < t - 300) {
            queue.removeFirst();
        }
        return queue.size();
    }

    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}