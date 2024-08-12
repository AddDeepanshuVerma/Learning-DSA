package DailyCodeChallenge.Level_1;

import java.util.Arrays;

public class EqualSubstring_1208 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        System.out.println(equalSubstring(s, t, 3));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        System.out.println(Arrays.toString(arr));
        int start = 0, end = 0, maxSum = 0, currSum = 0;
        while (end < n) {
            currSum = currSum + arr[end];
            while (currSum > maxCost) {
                currSum = currSum - arr[start];
                start++;
            }
            maxSum = Math.max(maxSum, end - start + 1);
            end++;
        }
        return maxSum;
    }

    public static void equalSubstring2(String s, String t, int maxCost) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        System.out.println(Arrays.toString(arr));
        int start = 0, end = 0, count = 0,
                maxSum = 0, currSum = 0;
        while (end < n) {
            if (currSum > maxCost) {
                currSum = currSum - arr[start];
                start++;
            } else {
                currSum = currSum + arr[end];
                end++;
                count++;
            }
            maxSum = Math.max(maxSum, currSum);
        }
    }
}
