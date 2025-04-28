package POTD_LEETCODE.Array;

import java.util.Arrays;

class CheckValidCuts_3394_2 {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return is_Axis_CutPossible(rectangles, 1, 3) || is_Axis_CutPossible(rectangles, 0, 2);
    }

    private boolean is_Axis_CutPossible(int[][] rectangles, int x, int y) {
        Arrays.sort(rectangles, (a, b) -> a[x] - b[x]);
        int count = 0;
        int min = 0, max = 0;
        for (int[] arr : rectangles) {
            int start = arr[x], end = arr[y];
            if (start >= max) {
                min = start;
                max = end;
                if (++count == 3) return true;
            } else {
                max = Math.max(max, end);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}};
        var obj = new CheckValidCuts_3394_2();
        System.out.println(obj.checkValidCuts(n, rectangles));
    }
}