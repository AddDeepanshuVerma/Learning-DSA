package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.List;

public class Rat_In_Maze_BackTracking_2 {
    static List<String> list;

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1, 1}, {0, 0, 0, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}, {1, 1, 1, 1, 1}};
        find_all_possible_ways(arr);
        System.out.println(list);
    }

    private static void find_all_possible_ways(int[][] arr) {
        list = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        int row = 0, col = 0;
        solve(path, arr, row, col);
    }

    private static void solve(ArrayList<String> path, int[][] arr, int row, int col) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[row].length || arr[row][col] == 0) return;
        if (row == arr.length - 1 && col == arr[row].length - 1) {
            list.add(String.join("", path));
            return;
        }
        arr[row][col] = 0;

        path.add("U");
        solve(path, arr, row - 1, col);
        path.removeLast();

        path.add("D");
        solve(path, arr, row + 1, col);
        path.removeLast();

        path.add("R");
        solve(path, arr, row, col + 1);
        path.removeLast();

        path.add("L");
        solve(path, arr, row, col - 1);
        path.removeLast();

        arr[row][col] = 1;

    }
}
