package _20_DynamicProgramming.LeetCode.hard;

class MinTravelTime_3538 {
    public static int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        int idx = 1, prevIdx = 0, offSet = 0;
        return dfs(idx, prevIdx, position, time, k, n);
    }

    private static int dfs(int i, int prevIdx, int[] position, int[] time, int k, int n) {
        int delta = (position[i] - position[prevIdx]) * (time[prevIdx]);
        if (i == n - 1) {
            return k == 0 ? delta : Integer.MAX_VALUE >> 1;
        }

        int pick = delta + dfs(i + 1, i, position, time, k, n);
        int notPick = Integer.MAX_VALUE;
        if (k > 0) {
            time[i + 1] += time[i];
            notPick = dfs(i + 1, prevIdx, position, time, k - 1, n);
            time[i + 1] -= time[i];
        }

        return Math.min(pick, notPick);
    }

    public static void main(String[] args) {
//        int l = 10, n = 4, k = 1;
//        int[] position = {0, 3, 8, 10}, time = {5, 8, 3, 6};

        int l = 5, n = 5, k = 1;
        int[] position = {0, 1, 2, 3, 5}, time = {8, 3, 9, 3, 3};

        int ans = minTravelTime(l, n, k, position, time);
        System.out.println("ans = " + ans);
    }
}