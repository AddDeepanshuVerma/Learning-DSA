package POTD_LEETCODE.HashTable;

import java.util.HashMap;
import java.util.Map;

class FirstCompleteIndex_2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int numRows = mat.length, numCols = mat[0].length;
        int[] rowCount = new int[numRows], colCount = new int[numCols];
        Map<Integer, int[]> map = new HashMap<>();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int value = mat[row][col];
                map.put(value, new int[]{row, col});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int[] pos = map.get(arr[i]);
            rowCount[pos[0]]++;
            colCount[pos[1]]++;
            if (rowCount[pos[0]] == numCols || colCount[pos[1]] == numRows) {
                return i;
            }
        }

        return -1;
    }
}