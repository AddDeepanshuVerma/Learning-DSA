package LeetCode_33Question_challenge_2025.week3;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Q9 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.addLast(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (!q.isEmpty() && q.peekLast()[1] >= currStart) {
                int[] last = q.pollLast();
                q.offer(new int[]{last[0], Math.max(last[1], currEnd)});
            } else {
                q.offer(new int[]{currStart, currEnd});
            }
        }

        int[][] res = new int[q.size()][2];
        int idx = 0;
        while (!q.isEmpty()) {
            int[] first = q.pollFirst();
            res[idx++] = first;
        }

        return res;
    }
}
