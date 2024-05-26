package Searching_06;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] arr2D = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int[][] arr2D1 = null;
        System.out.println(searchMatrix(arr2D1, 7));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowStart = 0,
                rowEnd = matrix.length - 1;
        if (matrix.length == 1) {
            return binarySearch(matrix, 0, target);
        }
        int columnStart = 0,
                columnEnd = matrix[0].length - 1,
                columnMid = (columnStart + columnEnd) >> 1;
        while (rowEnd - rowStart > 1) {
            int rowMid = (rowStart + rowEnd) >> 1;
            if (target == matrix[rowMid][columnMid]) {
                return true;
            } else if (target < matrix[rowMid][columnMid]) {
                rowEnd = rowMid;
            } else {
                rowStart = rowMid;
            }
        }
        //now either we got the target or left with two rows
        // Search element in both rows
        if (binarySearch(matrix, rowStart, target)) {
            return true;
        } else return binarySearch(matrix, rowEnd, target);
    }

    private static boolean binarySearch(int[][] matrix, int row, int target) {
        int start = 0,
                end = matrix[row].length-1,
                mid = 0;
        while (start <= end) {
            mid = (start + end)>>1;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target < matrix[row][mid]) {
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
}
