package POTD_LEETCODE.Greedy;

import java.util.PriorityQueue;

class PutMarbles_2551 {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < weights.length - 1; i++) {
            int val = weights[i] + weights[i + 1];
            min.offer(val);
            max.offer(val);
        }

        long ans = 0;
        while (--k > 0) {
            ans += (max.poll() - min.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        var obj = new PutMarbles_2551();
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        System.out.println(obj.putMarbles(weights, k));
    }
}