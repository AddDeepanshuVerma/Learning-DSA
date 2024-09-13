package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class TaskScheduler_LeastInterval_621_4 {
    public static void main(String[] args) {
        char[] arr = {'A', 'C', 'A', 'B', 'D', 'B'};
        TaskScheduler_LeastInterval_621_4 obj = new TaskScheduler_LeastInterval_621_4();
        System.out.println(obj.leastInterval(arr, 1));
    }


    @Description("Greedy + more cleaner and compact code without using map")
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) freq[ch - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int j : freq) {
            if (j > 0) pq.offer(j);
        }
        int empty = pq.poll() - 1;
        int ideal = empty * n;
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            ideal -= Math.min(temp, empty);
        }
        return ideal <= 0 ? tasks.length : tasks.length + ideal;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) freq[ch - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int j : freq) {
            if (j > 0) pq.offer(j);
        }
        int empty = pq.poll() - 1;
        int ideal = empty * n;
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            ideal -= Math.min(temp, empty);
            if (ideal <= 0) {
                ideal = 0;
                break;
            }
        }
        return tasks.length + ideal;
    }

    public int leastInterval3(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for (char c : tasks) {
            taskFreq[c - 'A']++;
        }
        Arrays.sort(taskFreq);

        int empty = taskFreq[25];
        int ideal = --empty * n;
        for (int i = 24; i > 0; i--) {
            ideal -= Math.min(taskFreq[i], empty);
        }
        return ideal > 0 ? tasks.length + ideal : tasks.length;
    }

}















