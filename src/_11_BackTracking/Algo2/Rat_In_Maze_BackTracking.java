package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.List;

public class Rat_In_Maze_BackTracking {
    static List<String> list;

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1, 1}, {0, 0, 0, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}, {1, 1, 1, 1, 1}};
        find_all_possible_ways(arr);
        System.out.println(list);
    }

    private static void find_all_possible_ways(int[][] arr) {
        list = new ArrayList<>();
        StringBuilder op = new StringBuilder();
        int row = 0, col = 0;
        solve(op, arr, row, col);
    }

    private static void solve(StringBuilder op, int[][] arr, int row, int col) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[row].length || arr[row][col] == 0) return;
        if (row == arr.length - 1 && col == arr[row].length - 1) {
            list.add(op.toString());
            return;
        }
        arr[row][col] = 0;

        solve(op.append("U"), arr, row - 1, col);
        op.deleteCharAt(op.length() - 1);

        solve(op.append("D"), arr, row + 1, col);
        op.deleteCharAt(op.length() - 1);

        solve(op.append("R"), arr, row, col + 1);
        op.deleteCharAt(op.length() - 1);

        solve(op.append("L"), arr, row, col - 1);
        op.deleteCharAt(op.length() - 1);

        arr[row][col] = 1;

    }
}
