package _11_BackTracking.Algo2;

import java.util.ArrayList;
import java.util.List;

public class Rat_In_Maze_Recursion {
    static List<String> list;

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        find_all_possible_ways(arr);
        System.out.println(list);
    }

    private static void find_all_possible_ways(int[][] arr) {
        list = new ArrayList<>();
        String op = "";
        int i = 0, j = 0;
        solve(op, arr, i, j);
    }

    private static void solve(String op, int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == 0) return;
        if (i == arr.length - 1 && j == arr[i].length - 1) {
            list.add(op);
            return;
        }
        arr[i][j] = 0;

        solve(op + "U", arr, i - 1, j);
        solve(op + "D", arr, i + 1, j);
        solve(op + "R", arr, i, j + 1);
        solve(op + "L", arr, i, j - 1);

        arr[i][j] = 1;

    }
}
