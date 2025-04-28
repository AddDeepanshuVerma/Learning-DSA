package POTD_LEETCODE.PriorityQueue;

import java.util.PriorityQueue;

class PickGifts_2558 {
    public static void main(String[] args) {
        int[] nums = {25, 64, 9, 4, 100};
        System.out.println(pickGifts(nums, 4));
    }

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) pq.add(gift);

        long sum = 0;
        while (k-- > 0) {
            int top = pq.remove();
            top = (int) Math.floor(Math.sqrt(top));
            pq.add(top);
        }
        while (!pq.isEmpty()) {
            sum += pq.remove();
        }

        return sum;
    }
}