package _11_BackTracking.Algo1;

import java.util.ArrayList;
import java.util.List;

public class RateInMaze_dp4 {
    private static final int[] choice = {0, -1, 0, 1, 0};
    private static final String dir = "LURD";

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        ArrayList<String> path = findPath(arr, 5);
        System.out.println(path);
    }

    private static ArrayList<String> findPath(int[][] arr, int n) {
        ArrayList<String> list = new ArrayList<>();
        solve(arr, n, 0, 0, "", list);
        return list.isEmpty() ? new ArrayList<>(List.of("-1")) : list;
    }

    private static void solve(int[][] arr, int n, int row, int col, String op, ArrayList<String> list) {
        if (row < 0 || row >= n || col < 0 || col >= n || arr[row][col] == 0) return;
        if (row == n - 1 && col == n - 1) list.add(op);

        arr[row][col] = 0;
        for (int i = 0; i < choice.length - 1; i++)
            solve(arr, n, row + choice[i], col + choice[i + 1], op + dir.charAt(i), list);
        arr[row][col] = 1;
    }
}
