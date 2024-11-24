package POTD_LEETCODE.String;

import java.util.ArrayDeque;

class MinLength_2696 {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                s = s.replace("AB", "");
            } else {
                s = s.replace("CD", "");
            }
        }
        return s.length();
    }

    public int minLength2(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.contains("AB") ? s.replace("AB", "") : s.replace("CD", "");
        }
        return s.length();
    }

    public int minLength3(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            switch (ch) {
                case 'B' -> {
                    if (!stack.isEmpty() && stack.peekFirst() == 'A') {
                        stack.removeFirst();
                    } else stack.addFirst(ch);
                }
                case 'D' -> {
                    if (!stack.isEmpty() && stack.peekFirst() == 'C') {
                        stack.removeFirst();
                    } else stack.addFirst(ch);
                }
                default -> {
                    stack.addFirst(ch);
                }
            }
        }
        return stack.size();
    }

    public int minLength4(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            switch (ch) {
                case 'B' -> {
                    if (!stack.isEmpty() && stack.peekFirst() == 'A') {
                        stack.removeFirst();
                        continue;
                    }
                }
                case 'D' -> {
                    if (!stack.isEmpty() && stack.peekFirst() == 'C') {
                        stack.removeFirst();
                        continue;
                    }
                }
            }
            stack.addFirst(ch);
        }
        return stack.size();
    }
}