package POTD_LEETCODE.String;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

class ClearDigits_174 {
    public static void main(String[] args) {
        System.out.println(clearDigits2("a3"));
    }

    public static String clearDigits(String s) {
        char[] arr = s.toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!Character.isDigit(arr[i])) {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                set.add(stack.pop());
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isDigit(arr[i]) && !set.contains(i)) {
                ans.append(arr[i]);
            }
        }
        return ans.toString();
    }

    public static String clearDigits2(String s) {
        char[] arr = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char ch : arr) {
            if (ch >= 'a' && ch <= 'z') ans.append(ch);
            else ans.deleteCharAt(Math.max(ans.length() - 1, 0));
        }
        return ans.toString();
    }

    public static String clearDigits3(String s) {
        char[] arr = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char ch : arr) {
            if (ch >= 'a' && ch <= 'z') ans.append(ch);
            else if (!ans.isEmpty()) ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }
}