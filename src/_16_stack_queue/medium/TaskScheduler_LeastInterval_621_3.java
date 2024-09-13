package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class TaskScheduler_LeastInterval_621_3 {
    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'A', 'A', 'B', 'C', 'C'};
        TaskScheduler_LeastInterval_621_3 obj = new TaskScheduler_LeastInterval_621_3();
        System.out.println(obj.leastInterval(arr, 1));
    }


    @Description("more cleaner and compact code without using map")
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];   
        for (char ch : tasks) freq[ch - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int j : freq) {
            if (j > 0) pq.offer(j);
        }

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= (n + 1); i++) {
                if (!pq.isEmpty()) list.add(pq.poll() - 1);
            }
            for (int nFreq : list)
                if (nFreq > 0) pq.add(nFreq);
            time += pq.isEmpty() ? list.size() : (n + 1);
        }
        return time;
    }
}















