package Strings.medium;

import java.util.Arrays;

class CanReach_1871 {
    public static void main(String[] args) {
        System.out.println(canReach2("00111010", 3, 5));
    }

//    Input: s = "011010", minJump = 2, maxJump = 3

    private static boolean canReach(String str, int min, int max) {
        int n = str.length();
        if (str.charAt(n - 1) != '0') return false;

        int index = 0;
        int i = 0;
        for (i = 1; i < str.length(); i++) {
            int distance = i - index;
            if (str.charAt(i) == '0' && distance >= min) {
                if (distance <= max) {
                    index = i;
                } else {
                    return false;
                }
            }
        }
        return index == n - 1;
    }

    public static boolean canReach2(String s, int minJump, int maxJump) {
        int count = 0;
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;

        for (int i = minJump; i < s.length(); ++i) {
            count += dp[i - minJump] ? 1 : 0;
            if (i - maxJump > 0)
                count -= dp[i - maxJump - 1] ? 1 : 0;
            dp[i] = count > 0 && s.charAt(i) == '0';
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(s.toCharArray()));
        return dp[dp.length - 1];
    }

    public static boolean canReach3(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;

        int index = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        while (index < n - 1) {
            firstIndex = Math.min(index + minJump, n - 1);
            lastIndex = Math.min(index + maxJump, n - 1);
            if ((firstIndex - index) < minJump) {
                return false;
            }
            index = searchLastIndexOfZero(s, firstIndex, lastIndex + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static int searchLastIndexOfZero(String s, int firstIndex, int lastIndex) {
        char[] arr = s.toCharArray();
        for (int i = lastIndex - 1; i >= firstIndex; i--) {
            if (arr[i] == '0') {
                return i;
            }
        }
        return -1;
    }
}