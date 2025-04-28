package _10_Recursion.easy;

import jdk.jfr.Description;

import java.util.Arrays;

class ReverseString_recursion_344 {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        ReverseString_recursion_344 obj = new ReverseString_recursion_344();
        obj.reverseString(arr);
    }

    public void reverseString(char[] arr) {
        System.out.println("arr = " + Arrays.toString(arr));
        dfs(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Description("Logic")
    private void dfs(char[] arr, int start, int end) {
        if (start > end) return;
        char ch = arr[start];
        dfs(arr, start + 1, end);
        arr[end - start] = ch;
    }

    private void dfs2(char[] arr, int start, int end) {
        if (start <= end) {
            char ch = arr[start];
            dfs2(arr, start + 1, end);
            arr[end - start] = ch;
        }
    }
}