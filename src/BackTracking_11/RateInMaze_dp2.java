package BackTracking_11;

import java.util.ArrayList;

public class RateInMaze_dp2 {
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
        int row = 0;
        int col = 0;
        solve(arr, n, row, col, new StringBuilder(), list);
        return list;
    }

    private static void solve(int[][] arr, int n, int row, int col, StringBuilder op, ArrayList<String> list) {
        if (row < 0 || row >= n || col < 0 || col >= n || arr[row][col] == 0) return;
        if (row == n - 1 && col == n - 1) list.add(op.toString());

        arr[row][col] = 0;
        op.append('U');
        solve(arr, n, row - 1, col, op, list);
        op.deleteCharAt(op.length() - 1);

        op.append('D');
        solve(arr, n, row + 1, col, op, list);
        op.deleteCharAt(op.length() - 1);

        op.append('R');
        solve(arr, n, row, col + 1, op, list);
        op.deleteCharAt(op.length() - 1);

        op.append('L');
        solve(arr, n, row, col - 1, op, list);
        op.deleteCharAt(op.length() - 1);

        arr[row][col] = 1;
    }
}
