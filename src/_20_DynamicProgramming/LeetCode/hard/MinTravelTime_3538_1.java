package _20_DynamicProgramming.LeetCode.hard;

class MinTravelTime_3538_1 {
    public static int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        int idx = 1, prevIdx = 0, offSet = 0;
        return dfs(idx, prevIdx, position, time, k, n, offSet);
    }

    private static int dfs(int i, int prevIdx, int[] position, int[] time, int k, int n, int offset) {
        int delta = (position[i] - position[prevIdx]) * (time[prevIdx] + offset);
        if (i == n - 1) {
            return k == 0 ? delta : Integer.MAX_VALUE >> 1;
        }

        int pick = delta + dfs(i + 1, i, position, time, k, n, 0);
        int notPick = Integer.MAX_VALUE;
        if (k > 0) {
            notPick = dfs(i + 1, prevIdx, position, time, k - 1, n, offset + time[i]);
        }

        return Math.min(pick, notPick);
    }

    public static void main(String[] args) {
        int l = 5, n = 5, k = 1;
        int[] position = {0, 1, 2, 3, 5}, time = {8, 3, 9, 3, 3};

        int ans = minTravelTime(l, n, k, position, time);
        System.out.println("ans = " + ans);
    }
}