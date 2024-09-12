package _10_Recursion.easy;

import jdk.jfr.Description;

import java.util.Arrays;

class ReverseArray_recursion {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        ReverseArray_recursion obj = new ReverseArray_recursion();
        obj.reverseString(arr);
    }

    public void reverseString(int[] arr) {
        System.out.println("arr = " + Arrays.toString(arr));
        dfs(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    @Description("Logic")
    private void dfs(int[] arr, int start, int end) {
        if (start > end) return;
        int ch = arr[start];
        dfs(arr, start + 1, end);
        arr[end - start] = ch;
    }

    private void dfs2(int[] arr, int start, int end) {
        if (start <= end) {
            int ch = arr[start];
            dfs2(arr, start + 1, end);
            arr[end - start] = ch;
        }
    }
}