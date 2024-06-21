package DailyCodeChallenge;

import java.util.Arrays;

public class ReverseString_344 {
    public static void main(String[] args) {
        //s = ["h","e","l","l","o"]
        char[] arr = {'h','e','l','l','o'};
        System.out.println(Arrays.toString(arr));
        reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            replace(s, start, end);
            start++;
            end--;
        }
    }

    private static void replace(char[] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }
}
