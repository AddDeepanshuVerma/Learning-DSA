package POTD_LEETCODE.BackTracking;

import java.util.ArrayList;
import java.util.PriorityQueue;

class CountMaxOrSubsets_2044 {
    public int countMaxOrSubsets(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> b.value - a.value); /*{max Value, count}*/
        int index = 0;
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, index, path, pq);
        return !pq.isEmpty() ? pq.peek().count : -1;

    }

    private void dfs(int[] nums, int index, ArrayList<Integer> path, PriorityQueue<Pair> pq) {
        if (index == nums.length) {
            // get the data of this path from list and take OR of all those elements and put in pq
            int res = getOR(path);
            int count = 0;
            if (!pq.isEmpty() && pq.peek().value == res) {
                Pair poll = pq.poll();
                count = poll.count;
            }
            pq.add(new Pair(res, count + 1));
            return;
        }

        // either we take this index or not
        path.add(nums[index]);
        dfs(nums, index + 1, path, pq);
        path.removeLast();
        dfs(nums, index + 1, path, pq);

    }

    private int getOR(ArrayList<Integer> path) {
        int res = 0;
        for (int num : path) res |= num;
        return res;
    }

    record Pair(int value, int count) {
    }
}