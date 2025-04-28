package POTD_LEETCODE.Two_Pointer;

import jdk.jfr.Description;

import java.util.ArrayDeque;

@Description("Approach not valid for a lot of TCs")
class Solution_2337 {
    public static void main(String[] args) {
        System.out.println(canChange("_R", "R_"));
    }

    public static boolean canChange(String start, String target) {
        start = getProcessedString(start);
        target = getProcessedString(target);

        return start.equals(target);
    }

    private static String getProcessedString(String start) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (char c : start.toCharArray()) {
            switch (c) {
                case '_' -> {
                    count = 0;
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        count++;
                        stack.pop();
                    }
                    stack.push('_');
                    while (count-- > 0) {
                        stack.push('R');
                    }
                }
                case 'L' -> {
                    count = 0;
                    while (!stack.isEmpty() && stack.peek() == '_') {
                        count++;
                        stack.pop();
                    }
                    stack.push('L');
                    while (count-- > 0) {
                        stack.push('_');
                    }

                }
                default -> stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}