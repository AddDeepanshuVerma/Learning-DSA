package LeetCode_33Question_challenge_2025.week2;

import java.util.ArrayDeque;
import java.util.HashSet;

public class demo {
    public String minRemoveToMakeValid(String s) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) continue;
            if (ch == '(') dq.addLast(i);
            else {
                if (!dq.isEmpty() && s.charAt(dq.peekLast()) == '(') dq.removeLast();
                else dq.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(dq);
        for (int i = 0; i < s.length(); i++)
            if (!set.contains(i)) sb.append(s.charAt(i));
        return sb.toString();
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        for (int[] q : queries) {
            int first = q[0], second = q[1];
            arr[first]--;
            arr[second + 1]++;
        }

        int currDec = 0;
        for (int i = 0; i < n; i++) {
            currDec += arr[i];
            if (nums[i] + currDec > 0) {
                return false;
            }
        }
        return true;
    }
}
