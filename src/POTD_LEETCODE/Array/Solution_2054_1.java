package POTD_LEETCODE.Array;

import jdk.jfr.Description;

import java.util.Arrays;

class Solution_2054_1 {
    public static void main(String[] args) {
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(maxTwoEvents2(events));
    }

    @Description("Now at the end Applied Custom Sorting + BinarySearch + PrefixSum Beats 96.75% 🌟🌟🌟")
    public static int maxTwoEvents2(int[][] events) {
        // sort as per start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int max = 0;
        int[] prefix = new int[events.length + 1];
        for (int i = prefix.length - 2; i >= 0; i--) {
            prefix[i] = Math.max(prefix[i + 1], events[i][2]);
        }

        for (int i = 0; i < events.length; i++) {
            max = Math.max(max, events[i][2]);
            int validIndex = binarySearch(events, events[i][1], i);
            // now find what is the max value from {n-1 till validIndex}
            int val = prefix[validIndex];
            max = Math.max(max, events[i][2] + val);
        }
        return max;
    }

    private static int binarySearch(int[][] events, int min, int start) {
        int ans = events.length;

        int end = events.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (events[mid][0] > min) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}