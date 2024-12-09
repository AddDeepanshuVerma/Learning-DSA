package POTD_LEETCODE.Array;

import jdk.jfr.Description;

import java.util.Arrays;

@Description("Using DP")
class Solution_2054_3 {
    public static void main(String[] args) {
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(maxTwoEvents(events));
    }

    static int[][] dp;
    static int n;

    public static int maxTwoEvents(int[][] events) {
        n = events.length;
        dp = new int[n + 1][3]; // Be specific about dp length, do Assign based on question's constraints
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int index = 0, count = 0;
        return dfs(events, index, count);
    }

    private static int dfs(int[][] events, int index, int count) {
        if (index == n || count == 2) return 0;
        if (dp[index][count] != -1) {
            return dp[index][count];
        }

        int validIndex = binarySearch(events, events[index][1]);
        int pick = events[index][2] + dfs(events, validIndex, count + 1);
        int notPick = dfs(events, index + 1, count);

        return dp[index][count] = Math.max(pick, notPick);
    }

    private static int binarySearch(int[][] events, int minVal) {
        int start = 0, end = n - 1;
        int ans = n;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (events[mid][0] > minVal) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}