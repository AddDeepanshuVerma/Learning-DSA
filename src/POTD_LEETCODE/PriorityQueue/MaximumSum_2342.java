package POTD_LEETCODE.PriorityQueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

class MaximumSum_2342 {
    public static void main(String[] args) {
        int[] nums = {229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366, 401};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = sumDigit(nums[i]);
            map.computeIfAbsent(sum, val -> new PriorityQueue<>(Collections.reverseOrder())).add(nums[i]);
//            map.computeIfAbsent(sum, val -> new PriorityQueue<>((a, b) -> b - a)).add(nums[i]);
        }

        int ans = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() > 1) {
                int first = pq.poll(), second = pq.poll();
                ans = Math.max(ans, first + second);
            }
        }
        return ans;
    }

    private static int sumDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}