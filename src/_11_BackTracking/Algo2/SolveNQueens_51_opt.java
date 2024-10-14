package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolveNQueens_51_opt {
    static List<List<String>> res;

    public static void main(String[] args) {
        SolveNQueens_51_opt obj = new SolveNQueens_51_opt();
        List<List<String>> lists = obj.solveNQueens(4);
        for (List<String> list : lists) System.out.println("list = " + list);
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[][] grid = new int[n][n];
        for (int[] arr : grid) Arrays.fill(arr, -1);
        int row = 0, queen = 0;
        solve(grid, row, n, queen, new ArrayList<>());
        return res;
    }

    private void solve(int[][] grid, int row, int n, int queen, List<String> temp) {
        if (queen == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int col = 0; col < n; col++) {
            // can we put queen at any column 0 till n for this ROW ?
            if (grid[row][col] == -1) {
                putQueen(grid, row, col, queen);
                temp.add(generateString(col, n));// we put the queen at this column for this particular row
                // now check for another queen to put in next row (each row has to have 1 queen)
                solve(grid, row + 1, n, queen + 1, temp);
                // Back track everything we did before above recursion call
                removeQueen(grid, queen);
                temp.removeLast();
            }
        }
    }

    private String generateString(int col, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(".".repeat(Math.max(0, n)));
        sb.replace(col, col + 1, "Q");
        return sb.toString();
    }

    private void removeQueen(int[][] grid, int queen) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == queen) grid[i][j] = -1;
            }
        }
    }

    private void putQueen(int[][] grid, int row, int col, int queen) {
        grid[row][col] = queen;
        int n = grid.length;
        // put all columns for this row to queen value if they are -1
        // put all rows for this col to queen value if they are -1
        for (int j = 0; j < n; j++) {
            if (grid[row][j] == -1) grid[row][j] = queen;
            if (grid[j][col] == -1) grid[j][col] = queen;
        }
        // put all diagonal values to queen value if they are -1
        //1. put all above right to queen level
        int i = row, j = col;
        //top right
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (grid[i][j] == -1) grid[i][j] = queen;
            i--;
            j++;
        }

        i = row;
        j = col;
        //bottom right
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (grid[i][j] == -1) grid[i][j] = queen;
            i++;
            j++;
        }

        i = row;
        j = col;
        //top left
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (grid[i][j] == -1) grid[i][j] = queen;
            i--;
            j--;
        }

        i = row;
        j = col;
        //bottom left
        while (i >= 0 && i < n && j >= 0 && j < n) {
            if (grid[i][j] == -1) grid[i][j] = queen;
            i++;
            j--;
        }

    }

}