package _11_BackTracking.Algo1;

import java.util.ArrayList;

public class RateInMaze_dp1 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1}
        };
        ArrayList<String> path = findPath(arr, 5);
        System.out.println(path);
    }

    private static ArrayList<String> findPath(int[][] arr, int n) {
        ArrayList<String> list = new ArrayList<>();
        solve(arr, n, 0, 0, "", list);
        return list;
    }

    private static void solve(int[][] arr, int n, int row, int col, String op, ArrayList<String> list) {
        if (row < 0 || row >= n || col < 0 || col >= n || arr[row][col] == 0) return;
        if (row == n - 1 && col == n - 1) list.add(op);

        arr[row][col] = 0;
        solve(arr, n, row - 1, col, op + 'U', list);
        solve(arr, n, row + 1, col, op + 'D', list);
        solve(arr, n, row, col + 1, op + 'R', list);
        solve(arr, n, row, col - 1, op + 'L', list);
        arr[row][col] = 1;
    }
}
