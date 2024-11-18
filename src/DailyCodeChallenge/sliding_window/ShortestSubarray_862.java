package DailyCodeChallenge.sliding_window;

import java.util.ArrayDeque;

class ShortestSubarray_862 {
    public static void main(String[] args) {
        ShortestSubarray_862 obj = new ShortestSubarray_862();
        int[] nums = {1};
        System.out.println(obj.shortestSubarray(nums, 1));
    }

    public int shortestSubarray(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        long[] cumSum = new long[nums.length];

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            cumSum[j] = (j == 0 ? 0 : cumSum[j - 1]) + nums[j];
            if (cumSum[j] >= k) {
                ans = Math.min(ans, j + 1);
            }
            while (!dq.isEmpty() && cumSum[j] - cumSum[dq.peekFirst()] >= k) {
                ans = Math.min(ans, j - dq.peekFirst());
                dq.removeFirst();
            }
            while (!dq.isEmpty() && cumSum[j] <= cumSum[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(j);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // Does not work : AS sliding window only works with nonNegative Integers array.
    public int shortestSubarray2(int[] nums, int k) {
        // find the shortest length whose sum == k
        int i = 0, j = 0, n = nums.length;
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        while (j < n) {
            sum += nums[j];
            while (i <= j && sum >= k) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}