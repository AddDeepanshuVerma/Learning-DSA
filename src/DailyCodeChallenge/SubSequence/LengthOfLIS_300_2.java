package DailyCodeChallenge.SubSequence;

import java.util.Arrays;

class LengthOfLIS_300_2 {
    public static void main(String[] args) {
        LengthOfLIS_300_2 obj = new LengthOfLIS_300_2();
        int[] arr = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(obj.lengthOfLIS(arr));
    }

    int[] dp;

    public int lengthOfLIS(int[] arr) {
        dp = new int[2501];
        Arrays.fill(dp, -1);

        int index = 0, length = 0, prev = -1;
        return dfs(index, length, arr, prev);
    }

    private int dfs(int index, int length, int[] arr, int prev) {
        if (index == arr.length) return 0;
        if (dp[index] != -1) {
            return dp[index];
        }

        int res = 0;
        if (length == 0) {
            for (int i = index; i < arr.length; i++) {
                res = Math.max(res, 1 + dfs(i + 1, length + 1, arr, arr[i]));
            }
        } else {
            for (int i = index; i < arr.length; i++) {
                if (prev < arr[i]) {
                    res = Math.max(res, 1 + dfs(i + 1, length + 1, arr, arr[i]));
                }
            }
        }
        return dp[index] = res;
    }
}