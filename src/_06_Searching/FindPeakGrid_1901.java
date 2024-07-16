package _06_Searching;

import java.util.Arrays;

public class FindPeakGrid_1901 {
    public static void main(String[] args) {
        int[][] arr2D = {
                {10,20,15},
                {21,30,14},
                {7,16,32}
        };
        int[][] arr2D1 = {
                {10,50,40,30,20},
                {1,500,2,3,4}
        };
        int[] peakGrid = findPeakGrid(arr2D1);
        System.out.println(Arrays.toString(peakGrid));
    }
    public static int[] findPeakGrid(int[][] mat) {
        //be cautions about MxN length to their bounds
        int[] res = {-1, -1};
        if(mat == null || mat.length == 0 || mat[0].length == 0)
            return res;
        for (int row = 0; row < mat.length; row++) {
            //find peak element in the array
            int columnIndex = findPeak(mat[row]);
            if (columnIndex != -1) {
                // check if this element is peak in its column as well
                boolean exists = columnPeakOrNot(mat, row, columnIndex);
                if(exists){
                    return new int[]{row, columnIndex};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static int findPeak(int[] arr) {
//        if (arr.length > 1 && arr[0] > arr[1]) return 0;
//        if (arr.length > 1 && arr[arr.length - 1] > arr[arr.length - 2]) return arr.length - 1;
        int start = 0, end = arr.length - 1, mid = 0;
        while (start < end) {
            mid = (start + end) >> 1;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean columnPeakOrNot(int[][] arr, int row, int column) {
        if (row > 0 && row < arr.length - 1) {
            if (arr[row][column] > arr[row + 1][column] && arr[row][column] > arr[row - 1][column])
                return true;
        } else if(arr.length - 1 - row >= 0) {
            if(row <= 0) return arr[row][column] > arr[row+1][column];
            if(row == arr.length - 1) return arr[row][column] > arr[row-1][column];
        }else{
            return true;
        }
        return false;
    }

}
