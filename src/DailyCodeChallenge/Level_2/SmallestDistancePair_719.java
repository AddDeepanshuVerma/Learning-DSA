package DailyCodeChallenge.Level_2;

import java.util.Collections;
import java.util.PriorityQueue;

class SmallestDistancePair_719 {
    PriorityQueue<Integer> pq;
    int defaultSize;

    public static void main(String[] args) {
        int[] nums = {1,6,1};
        int k = 3;
        SmallestDistancePair_719 obj = new SmallestDistancePair_719();
        System.out.println(obj.smallestDistancePair(nums, k));
    }

    public int smallestDistancePair(int[] nums, int k) {
        pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        pq = new PriorityQueue<>(Collections.reverseOrder());
        defaultSize = k;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                Pair pair = new Pair(nums[i], nums[j]);
                System.out.println(pair);
                addInPQ(Math.abs(nums[i] - nums[j]));
            }
        return pq.peek();
    }

    private void addInPQ(int element) {
        pq.add(element);
        if (pq.size() > defaultSize) pq.poll();
    }


    private record Pair(int a, int b) { }
}