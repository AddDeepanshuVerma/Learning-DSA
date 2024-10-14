package DailyCodeChallenge.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

class MinGroups_2406 {
    //intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]] : intervals[i] = [left, right]
    public int minGroups(int[][] intervals) {
        /* * 1. we will sort the array as per interval left value so that interval can be in sync
         * 2. now loop through interval.length for each element, we will put right(left) time in queue with asc order
         * 3. in asc if our current element left is Grater then queue's top value
         *   current element left > queue.top ? pop queue & put element's right in queue
         *                                    : put element's right in queue
         *  4. At the end queue size will be maximum chairs were required
         * */

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (!pq.isEmpty() && pq.peek() < left) {
                pq.poll();
                pq.add(right);
            } else {
                pq.add(right);
            }
        }
        return pq.size();
    }

    public int minGroups2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() < interval[0])
                pq.poll();
            pq.add(interval[1]);
        }
        return pq.size();
    }
}