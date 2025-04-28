package POTD_LEETCODE.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

class MaxKelements_2530 {
    public long maxKelements(int[] nums, int k) {
        /*
         * find max element of the array
         * add that element to our answer and change that element to  -> ceil(element / 3)
         * repeat above 2 steps k times
         * to find max element each time, use priority queue
         * */

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(nums).forEach(pq::add);

        long ans = 0;

        while (k-- > 0) {
            int poll = pq.poll();
            ans += poll;
            pq.add((int) Math.ceil(poll / 3.0));
        }
        return ans;
    }
}