package POTD_LEETCODE.prefix;

import jdk.jfr.Description;

import java.util.Arrays;

class GridGame_2017 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1, 15}, {1, 3, 3, 1}};
        System.out.println(gridGame(grid));
    }

    private static long gridGame(int[][] grid) {
//        long topSum = Arrays.stream(grid[0]).sum(), bottomSum = 0;                // would not work
//        long topSum = Arrays.stream(grid[0]).asLongStream().sum(), bottomSum = 0; // works, but takes more time

        long topSum = 0, bottomSum = 0;
        int col = grid[0].length;
        for (int i = 0; i < col; i++) {
            topSum += grid[0][i];
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            topSum -= grid[0][i];
            ans = Math.min(ans, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }
        return ans;
    }


    @Description("Wrong approach, does not work")
    public static long gridGame2(int[][] grid) {
        long ans = 0, sum = 0;
        int m = grid.length, n = grid[0].length;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                sum += ints[j];
            }
        }
        int[] prefixA = new int[n + 1], prefixB = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixA[i] = grid[0][i - 1] + prefixA[i - 1];
            prefixB[i] = grid[1][i - 1] + prefixB[i - 1];
        }

        int i = 0, j = 0, currSum = grid[0][0];
        grid[0][0] = 0;
        while (true) {
            int above = getPrefix(prefixA, j + 1, n);
            int below = getPrefix(prefixB, j, n - 1);

            if (above > below) {
                j++;
                currSum += grid[i][j];
                grid[i][j] = 0;
            } else {
                currSum += getPrefix(prefixB, j, n);
                i++;
                while (j < n) {
                    grid[i][j] = 0;
                    j++;
                }
                break;
            }
        }
        System.out.println("grid = " + Arrays.deepToString(grid));
        Arrays.fill(prefixA, 0);
        Arrays.fill(prefixB, 0);
        for (int k = 1; k <= n; k++) {
            prefixA[k] = grid[0][k - 1] + prefixA[k - 1];
            prefixB[k] = grid[1][k - 1] + prefixB[k - 1];
        }

        i = 0;
        j = 0;
        currSum = 0;
        while (true) {
            int above = getPrefix(prefixA, j + 1, n);
            int below = getPrefix(prefixB, j, n - 1);

            if (above > below) {
                j++;
                currSum += grid[i][j];
                grid[i][j] = 0;
            } else {
                currSum += getPrefix(prefixB, j, n);
                i++;
                while (j < n) {
                    grid[i][j] = 0;
                    j++;
                }
                break;
            }
        }

        return currSum;
    }

    private static int getPrefix(int[] prefixA, int i, int j) {
        return prefixA[j] - prefixA[i];
    }
}