package _16_stack_queue.medium;

import java.util.ArrayDeque;
import java.util.Arrays;

class TaskScheduler_LeastInterval_621 {
    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'A', 'A', 'B', 'C', 'C'};
        TaskScheduler_LeastInterval_621 obj = new TaskScheduler_LeastInterval_621();
        System.out.println(obj.leastInterval(arr, 1));
    }
    public int leastInterval(char[] tasks, int n) {
        Arrays.sort(tasks);
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (char task : tasks) queue.push(task);
        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.peekFirst() != queue.peekLast()) {
                queue.poll();
                queue.pollLast();
                count++;
            } else {
                break;
            }
        }
        count <<= 1;
        if (queue.isEmpty()) {
            return count;
        } else {
            int size = queue.size();
            count = ++count + --size * (++n);
            return count;
        }
    }
}