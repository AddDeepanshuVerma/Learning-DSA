package POTD_LEETCODE.PriorityQueue;

import java.util.PriorityQueue;

class GetFinalState_3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // {value, index}

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        while (k-- > 0) {
            int[] poll = pq.poll();
            poll[0] *= multiplier;
            nums[poll[1]] = poll[0];
            pq.offer(poll);
        }
        return nums;
    }

    public int[] getFinalState2(int[] nums, int k, int multiplier) {
        int modulo = 1000_000_007;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0])); // {value, index}

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new long[]{nums[i], i});
        }

        while (k-- > 0) {
            long[] poll = pq.poll();
            poll[0] *= multiplier;
            pq.offer(poll);
        }

        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            nums[(int) poll[1]] = (int) (poll[0] % modulo);
        }

        return nums;
    }

    public int[] getFinalState3(int[] nums, int k, int multiplier) {
        int modulo = 1000_000_007;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0])); // {value, index}

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new long[]{nums[i], i});
        }

        while (k-- > 0) {
            long[] poll = pq.poll();
            poll[0] *= multiplier;
            pq.offer(poll);
        }

        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            nums[(int) poll[1]] = (int) (poll[0] % modulo);
        }

        return nums;
    }
}