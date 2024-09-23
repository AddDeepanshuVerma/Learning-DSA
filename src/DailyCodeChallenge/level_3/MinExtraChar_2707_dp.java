package DailyCodeChallenge.level_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// working with Recursion + memoization = Dp !!!!
class MinExtraChar_2707_dp {
    public static void main(String[] args) {
        String str = "sayhelloworld";
        String[] dictionary = {"hello", "world"};
        int count = minExtraChar(str, dictionary);
        System.out.println("ans = " + count);
    }

    public static int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[51];
        Arrays.fill(dp, -1);
        Set<String> dict = new HashSet<>(List.of(dictionary));
        int index = 0;
        return solve(index, s.toCharArray(), dict, dp);
    }

    private static int solve(int index, char[] arr, Set<String> dict, int[] dp) {
        if (index == arr.length) return 0;

        if (dp[index] != -1) return dp[index];

        int ans = arr.length;
        String subStr = "";
        for (int i = index; i < arr.length; i++) {
            subStr += arr[i];
            int count = (dict.contains(subStr) ? 0 : subStr.length()) + solve(i + 1, arr, dict, dp);
            ans = Math.min(count, ans);
        }
        return dp[index] = ans;
    }
}

