package POTD_LEETCODE.Array;

import jdk.jfr.Description;

import java.util.Arrays;

class Solution_2054 {
    public static void main(String[] args) {
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(maxTwoEvents2(events));
    }

    @Description("n^2 solution Obviously TLE for input n = 1e5, which made 40/63 Testcases (here events[i] = [startTimei, endTimei, valuei]) ")
    public static int maxTwoEvents(int[][] events) {
        int max = 0;

        for (int i = 0; i < events.length; i++) {
            max = Math.max(max, events[i][2]);
            for (int j = 0; j < events.length; j++) {
                if (Math.max(events[i][0], events[j][0]) <= Math.min(events[i][1], events[j][1])) continue;
//                if (events[j][0] <= events[i][1] && events[j][1] >= events[i][0]) continue;
                max = Math.max(max, events[i][2] + events[j][2]);
            }
        }
        return max;
    }

    // ================================================================

    @Description(" Did put use of binarySearch which made 49/63 Testcases")
    public static int maxTwoEvents2(int[][] events) {
        // sort as per start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int max = 0;

        for (int i = 0; i < events.length; i++) {
            max = Math.max(max, events[i][2]);
            // search the valid index where newStart time > current endTIme
            int validIndex = binarySearch(events, events[i][1], i);
            for (int j = validIndex; j < events.length; j++) {
                if (Math.max(events[i][0], events[j][0]) <= Math.min(events[i][1], events[j][1])) continue;
//                if (events[j][0] <= events[i][1] && events[j][1] >= events[i][0]) continue;
                max = Math.max(max, events[i][2] + events[j][2]);
            }
        }
        return max;
    }

    private static int binarySearch(int[][] events, int min, int start) {
        int ans = events.length;

        int end = events.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
//            Start time > min, find minimum index
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