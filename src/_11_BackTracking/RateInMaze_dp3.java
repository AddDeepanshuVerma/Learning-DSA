package _11_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RateInMaze_dp3 {
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
        int[][] choices = {
                {-1, 0, 'U'},
                {1, 0, 'D'},
                {0, 1, 'R'},
                {0, -1, 'L'},
        };
        ArrayList<String> list = new ArrayList<>();
        int row = 0;
        int col = 0;
        solve(arr, n, row, col, "", list, choices);
        return list.isEmpty() ? new ArrayList<>(List.of("-1")) : list;
    }

    private static void solve(int[][] arr, int n, int row, int col, String op, ArrayList<String> list, int[][] choices) {
        if (row < 0 || row >= n || col < 0 || col >= n || arr[row][col] == 0) return;
        if (row == n - 1 && col == n - 1) list.add(op);

        arr[row][col] = 0;
        for (int[] choice : choices)
            solve(arr, n, row + choice[0], col + choice[1], op + (char) choice[2], list, choices);
        arr[row][col] = 1;
    }
}
