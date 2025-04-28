package POTD_LEETCODE.PriorityQueue;

import java.util.PriorityQueue;

class FindScore_2593 {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // { value, index }
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (nums[poll[1]] < 0) continue; // it is already visited
            mark(poll[1], nums); // mark both adjacent as visited
            sum += poll[0];
        }
        return sum;
    }

    private void mark(int index, int[] nums) {
        if (nums[index] > 0) {
            nums[index] *= -1;
        }
        if (index > 0 && nums[index - 1] > 0) {
            nums[index - 1] *= -1;
        }
        if (index < nums.length - 1 && nums[index + 1] > 0) {
            nums[index + 1] *= -1;
        }
    }
}