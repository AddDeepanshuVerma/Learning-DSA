package POTD_LEETCODE.level_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// NOT working with memoization!!!!
class MinExtraChar_2707_4 {
    public static void main(String[] args) {
        String str = "sayhelloworld";
        String[] dictionary = {"hello", "world"};
        int count = breakString(str, dictionary);
        System.out.println("ans = " + count);
    }

    static int[] dp;

    private static int breakString(String str, String[] dictionary) {
        dp = new int[51];
        Arrays.fill(dp, -1);
        Set<String> set = new HashSet<>(List.of(dictionary));
        return solve(0, str.toCharArray(), set, str.length());
    }

    private static int solve(int index, char[] arr, Set<String> set, int remainingLength) {
        if (index == arr.length) return remainingLength;

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = remainingLength;
        String subStr = "";
        for (int i = index; i < arr.length; i++) {
            subStr += arr[i];
            ans = Math.min(solve(i + 1, arr, set, set.contains(subStr) ? remainingLength - subStr.length() : remainingLength), ans);
        }
        return dp[index] = ans;
    }

}