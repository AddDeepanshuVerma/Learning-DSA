package POTD_LEETCODE.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

class HalveArray_2208 {
    public static void main(String[] args) {
        int[] nums = {3, 8, 20};
        System.out.println(halveArray(nums));
    }

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (int num : nums) {
            pq.add((double) num);
            sum += num;
        }

        int count = 0;
        double currSum = 0;
        while (sum - currSum > sum / 2) {
            double poll = pq.poll() / 2;
            currSum += poll;
            pq.add(poll);
            count++;
        }
        return count;
    }
}