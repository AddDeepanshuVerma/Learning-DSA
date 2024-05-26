package Searching_06;

import java.util.Arrays;

public class FindPeakGrid_1901_2 {
    public static void main(String[] args) {
        int[][] arr2D = {
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}
        };
        int[][] arr2D1 = {
                {10, 50, 40, 30, 20},
                {1, 500, 2, 3, 4}
        };
        int[] peakGrid = findPeakGrid(arr2D1);
        System.out.println(Arrays.toString(peakGrid));
    }

    public static int[] findPeakGrid(int[][] arr) {
        int rowStart = 0;
        int rowEnd = arr.length - 1;
        int rowMid = 0;
        while (rowStart <= rowEnd) {
            rowMid = (rowStart + rowEnd) >> 1;
            int indexRowMaxElement = maxOfRow(arr, rowMid);
            int above = rowMid == 0 ? -1 : arr[rowMid - 1][indexRowMaxElement];
            int below = rowMid == arr.length - 1 ? -1 : arr[rowMid + 1][indexRowMaxElement];
            if (arr[rowMid][indexRowMaxElement] > above
                    && arr[rowMid][indexRowMaxElement] > below) {
                return new int[]{rowMid, indexRowMaxElement};
            } else if (arr[rowMid][indexRowMaxElement] < above) {
                rowEnd = rowMid - 1;
            }else{
                rowStart = rowMid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int maxOfRow(int[][] arr, int row) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < arr[row].length; i++) {
            if (arr[row][i] > max) {
                max = arr[row][i];
                index = i;
            }
        }
        return index;
    }


}
