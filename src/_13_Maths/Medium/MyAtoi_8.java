package _13_Maths.Medium;

import java.util.Stack;

class MyAtoi_8 {
    public static void main(String[] args) {
        String str = "9223372036854775808";
        MyAtoi_8 obj = new MyAtoi_8();
        System.out.println(obj.myAtoi(str));
    }

    public int myAtoi2(String s) {
        s = s.strip();
        if (s.isEmpty()) return 0;

        final int sign = s.charAt(0) == '-' ? -1 : 1;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);

        long ans = 0;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) break;
            ans = ans * 10 + (c - '0');
            if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (ans * sign);
    }

    public int myAtoi(String s) {
        s = s.strip();
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int sign = 1;
        boolean signUpdated = false;
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (stack.isEmpty() && (c == '-' || c == '+') && !signUpdated) {
                sign = c == '-' ? -1 : 1;
                signUpdated = true;
            } else if (Character.isDigit(c)) {
                stack.add(c);
            } else {
                break;
            }
        }
        long base = 1;
        while (!stack.isEmpty()) {
            ans += (stack.pop() - '0') * base;
            base *= 10;

            if (ans * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (ans * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        ans = ans * sign;
        return (int) ans;
    }
}