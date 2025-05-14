package Contest.Weekly_Contest._449;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q4 {

    public static void main(String[] args) {
        Q4 obj = new Q4();
        int[][] grid = {};
        boolean ans = obj.canPartitionGrid(grid);
        System.out.println("ans = " + ans);
    }

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long totalSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }
//        if ((totalSum & 1) == 1) return false;

        // now wee need to calculate each : rowSum, colSum, rowHashSet, colHashSet
        long[] rowSum = new long[m], colSum = new long[n];
        List<HashSet<Integer>> rowSet = new ArrayList<>();
        List<HashSet<Integer>> colSet = new ArrayList<>();

        // fill rowSum & rowSet
        for (int i = 0; i < m; i++) {
            int temp = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                temp += grid[i][j];
                set.add(grid[i][j]);
            }
            rowSum[i] = temp;
            rowSet.add(set);
        }

        // fill colSum & colSet
        for (int c = 0; c < n; c++) {
            int temp = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int r = 0; r < m; r++) {
                temp += grid[r][c];
                set.add(grid[r][c]);
            }
            colSum[c] = temp;
            colSet.add(set);
        }

        // now first check for first cut where we can only remove corners cases
        // lets start putting vertical cuts
        // let first check for first & last verticalCut
        for (int idx : new int[]{0, n - 1}) {
            if ((colSum[idx] << 1) == totalSum) return true;
            if (((colSum[idx] << 1) < totalSum) && n >= 3) {
                int find = (int) (totalSum - (colSum[idx] << 1));
                if ((idx == 0) && (setRangeContains(idx + 1, n, colSet, find))) {
                    return true;
                } else if ((idx == n - 1) && (setRangeContains(0, idx, colSet, find))) {
                    return true;
                }
            } else {
                int find = (int) ((colSum[idx] << 1) - totalSum);
                if (grid[0][idx] == find || grid[m - 1][idx] == find) {
                    return true;
                }
            }
        }
        // let first check for first & last horizontalCut
        for (int idx : new int[]{0, m - 1}) {
            if ((rowSum[idx] << 1) == totalSum) return true;
            if (((rowSum[idx] << 1) < totalSum) && m >= 3) {
                int find = (int) (totalSum - (rowSum[idx] << 1));
                if ((idx == 0) && (setRangeContains(idx + 1, m, rowSet, find))) {
                    return true;
                } else if ((idx == m - 1) && (setRangeContains(0, idx, rowSet, find))) {
                    return true;
                }
            } else {
                int find = (int) ((rowSum[idx] << 1) - totalSum);
                if (grid[idx][0] == find || grid[idx][n - 1] == find) {
                    return true;
                }
            }
        }

        // now we need to check from 2nd column till end of col
        for (int i = 2; i < n - 1; i++) {
            long sum = firstHalfSum(0, i, colSum);
            if ((sum << 1) == totalSum) return true;
            else if ((sum << 1) > totalSum) {
                int find = (int) ((sum << 1) - totalSum);
                if (setRangeContains(0, i, colSet, find)) {
                    return true;
                }
            } else {
                int find = (int) (totalSum - (sum << 1));
                if (setRangeContains(i, n, colSet, find)) {
                    return true;
                }
            }
        }
        // now similarly 2nd row till end of row
        for (int i = 2; i < m - 1; i++) {
            long sum = firstHalfSum(0, i, rowSum);
            if ((sum << 1) == totalSum) return true;
            else if ((sum << 1) > totalSum) {
                int find = (int) ((sum << 1) - totalSum);
                if (setRangeContains(0, i, rowSet, find)) {
                    return true;
                }
            } else {
                int find = (int) (totalSum - (sum << 1));
                if (setRangeContains(i, m, rowSet, find)) {
                    return true;
                }
            }
        }

        return false;
    }

    private long firstHalfSum(int i, int j, long[] colSum) {
        long sum = 0;
        for (int k = i; k < j; k++) {
            sum += colSum[k];
        }
        return sum;
    }

    private boolean setRangeContains(int i, int j, List<HashSet<Integer>> colSet, int find) {
        for (int k = i; k < j; k++) {
            if (colSet.get(k).contains(find)) {
                return true;
            }
        }
        return false;
    }

}
