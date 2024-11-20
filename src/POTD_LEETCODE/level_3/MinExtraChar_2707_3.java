package POTD_LEETCODE.level_3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MinExtraChar_2707_3 {
    public static void main(String[] args) {
        String str = "sayhelloworld";
        String[] dictionary = {"hello", "world"};
        int count = breakString(str, dictionary);
        System.out.println("ans = " + count);
    }

    private static int breakString(String str, String[] dictionary) {
        Set<String> set = new HashSet<>(List.of(dictionary));
        return solve(0, str.toCharArray(), set, str.length());
    }

    private static int solve(int index, char[] arr, Set<String> set, int remainingLength) {
        if (index == arr.length) return remainingLength;

        int ans = remainingLength;
        String subStr = "";
        for (int i = index; i < arr.length; i++) {
            subStr += arr[i];
            ans = Math.min(solve(i + 1, arr, set, set.contains(subStr) ? remainingLength - subStr.length() : remainingLength), ans);
        }
        return ans;
    }

}