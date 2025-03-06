package POTD_LEETCODE.Array;

import java.util.Arrays;

class FindMissingAndRepeatedValues_2965 {
    public static void main(String[] args) {
        int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        int[] ans = findMissingAndRepeatedValues3(grid);
        System.out.println(Arrays.toString(ans));
    }

    // using extra space
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        int missing = -1, repeated = -1;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 1) repeated = i;
            if (count[i] == 0) missing = i;
        }

        return new int[]{repeated, missing};
    }

    // using swappable algorithm
    public int[] findMissingAndRepeatedValues2(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (grid[i][j] != grid[((grid[i][j] - 1) / n)][((grid[i][j] - 1) % n)]) {
                    swap(i, j, (grid[i][j] - 1) / n, (grid[i][j] - 1) % n, grid);
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != ((row * n) + col) + 1) {
                    return new int[]{grid[row][col], ((row * n) + col + 1)};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] findMissingAndRepeatedValues3(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int correctRow = (grid[i][j] - 1) / n;
                int correctCol = (grid[i][j] - 1) % n;
                while ((grid[i][j] != grid[correctRow][correctCol])) {
                    swap(i, j, correctRow, correctCol, grid);
                    correctRow = (grid[i][j] - 1) / n;
                    correctCol = (grid[i][j] - 1) % n;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int currValue = grid[row][col];
                int correctValue = ((row * n) + col) + 1;
                if (currValue != correctValue) {
                    return new int[]{currValue, correctValue};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private static void swap(int i, int j, int k, int l, int[][] grid) {
        int temp = grid[i][j];
        grid[i][j] = grid[k][l];
        grid[k][l] = temp;
    }
}