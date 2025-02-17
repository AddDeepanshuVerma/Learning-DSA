package POTD_LEETCODE.PriorityQueue;

import java.util.PriorityQueue;

class MinOperations_3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) pq.add((long) num);

        long min = !pq.isEmpty() ? pq.peek() : 0;
        int count = 0;

        while (pq.size() >= 2 && min < k) {
            long first = pq.poll(), second = !pq.isEmpty() ? pq.poll() : 0;
            pq.add((Math.min(first, second) << 1) + Math.max(first, second));
            count++;
            min = !pq.isEmpty() ? pq.peek() : k;
        }
        return count;
    }

    public int minOperations2(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) pq.add((long) num);

        long min = pq.peek();
        int count = 0;

        while (pq.size() >= 2 && min < k) {
            pq.add((pq.poll() << 1) + pq.poll());
            min = !pq.isEmpty() ? pq.peek() : k;
            count++;
        }
        return count;
    }

    public int minOperations3(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) pq.add((long) num);

        int count = 0;
        while (pq.size() >= 2 && pq.peek() < k) {
            pq.add((pq.poll() << 1) + pq.poll());
            count++;
        }
        return count;
    }

}