package Recursion_10;

import java.util.Arrays;

class ReverseString_344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        ReverseString_344.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        reverseIt(s, 0, s.length);
    }

    private static void reverseIt(char[] s, int start, int n) {
        if (n == 1) return;
        char c = s[start];
        reverseIt(s, start + 1, n - 1);
        insertChar(s, n - 1, c);
    }

    private static void insertChar(char[] s, int n, char c) {
        if (n == 0) {
            s[0] = c;
            return;
        }
        char c1 = s[n - 1];
        insertChar(s, n - 1, c);
        s[n] = c1;
    }
}