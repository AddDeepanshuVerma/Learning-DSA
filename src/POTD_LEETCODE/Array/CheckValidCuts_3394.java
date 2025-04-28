package POTD_LEETCODE.Array;

import java.util.Arrays;

class CheckValidCuts_3394 {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        // first Check horizontal cuts
        Arrays.sort(rectangles, (a, b) -> a[1] - b[1]); // sorting based on y-Axis start
        boolean flag = is_X_Axis_CutPossible(rectangles);
        if (flag) return true;
        // now Check vertical cuts
        Arrays.sort(rectangles, (a, b) -> a[0] - b[0]); // sorting based on x-Axis start
        flag = is_Y_Axis_CutPossible(rectangles);

        return flag;
    }

    private boolean is_X_Axis_CutPossible(int[][] rectangles) {
        int count = 0;
        int min = 0, max = 0;
        for (int[] arr : rectangles) {
            int start = arr[1], end = arr[3];
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

    private boolean is_Y_Axis_CutPossible(int[][] rectangles) {
        int count = 0;
        int min = 0, max = 0;
        for (int[] arr : rectangles) {
            int start = arr[0], end = arr[2];
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
        var obj = new CheckValidCuts_3394();
        System.out.println(obj.checkValidCuts(n, rectangles));
    }
}