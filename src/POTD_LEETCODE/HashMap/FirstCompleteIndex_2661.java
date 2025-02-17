package POTD_LEETCODE.HashMap;

import java.util.HashMap;

class FirstCompleteIndex_2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int[] grid = map.get(arr[i]);
            rowCount[grid[0]]++;
            colCount[grid[1]]++;
            if (rowCount[grid[0]] == n || colCount[grid[1]] == m) {
                return i;
            }
        }
        return -1;
    }
}