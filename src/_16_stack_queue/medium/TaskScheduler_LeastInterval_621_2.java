package _16_stack_queue.medium;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class TaskScheduler_LeastInterval_621_2 {
    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'A', 'A', 'B', 'C', 'C'};
        TaskScheduler_LeastInterval_621_2 obj = new TaskScheduler_LeastInterval_621_2();
        System.out.println(obj.leastInterval(arr, 1));
    }

    @Description("rusted code with explanation, need to clean")
    public int leastInterval(char[] tasks, int n) {
        /*
        - As we need a priority queue having frequencies of diff char
        - Create map based on freq of given char
        - Now create that PQ with DSC order
        - we are expecting to have at least (n + 1) cycle in a single go
          hence we will run a loop until pq is empty where we will pop element
          from PQ until it's empty and every time expects to add n+1 in our count
          here after reducing their frequency by 1, we will again push those
          elements back to PQ
         - Above process will continue until pq is empty
         - here once PQ is empty will be not be adding (n+1) in our count but
           what were the previous size of PQ which we fetched, and it made pq go empty.
         */
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

//        for (char c : tasks) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
        for (char c : tasks) map.merge(c, 1, Integer::sum);
//        System.out.println("map = " + map);

//        for (Integer value : map.values()) pq.add(value);
        pq.addAll(map.values());
        /*
        while (!pq.isEmpty()) {
            System.out.printf(pq.poll() + " ");
        }
        System.out.println();
        */
        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= (n + 1); i++) {
                if (!pq.isEmpty()) {
                    int freq = pq.poll();
                    freq--;
                    list.add(freq);
                }
            }
            for (int freq : list) {
                if (freq > 0) {
                    pq.add(freq);
                }
            }
            if (pq.isEmpty()) {
                time += list.size();
            } else {
                time += (n + 1);
            }
        }
        return time;
    }

    @Description("clean and compact code")
    public int leastInterval_2(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (char c : tasks)
            map.merge(c, 1, Integer::sum);
        pq.addAll(map.values());

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= (n + 1); i++) {
                if (!pq.isEmpty()) list.add(pq.poll() - 1);
            }
            for (int freq : list)
                if (freq > 0) pq.add(freq);
            time += pq.isEmpty() ? list.size() : (n + 1);
        }
        return time;
    }
}















