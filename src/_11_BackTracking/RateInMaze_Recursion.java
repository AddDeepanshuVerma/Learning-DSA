package _11_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RateInMaze_Recursion {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<String>();
        boolean[][] visited = new boolean[n][n];
        function(0, 0, m, m.length, m[0].length, "", ans, visited);
        return !ans.isEmpty() ? ans : new ArrayList<>(List.of("-1"));

    }

    public static void function(int i, int j, int[][] arr, int n, int m, String str, ArrayList<String> ans, boolean[][] visited) {
        if (i < n && j < m && i >= 0 && j >= 0 && arr[i][j] != 0 && !visited[i][j]) {

            if (i == n - 1 && j == m - 1) {
                ans.add(str);
                return;
            }

            visited[i][j] = true;
            function(i + 1, j, arr, n, m, str + "D", ans, visited);
            function(i - 1, j, arr, n, m, str + "U", ans, visited);
            function(i, j + 1, arr, n, m, str + "R", ans, visited);
            function(i, j - 1, arr, n, m, str + "L", ans, visited);
            visited[i][j] = false;
        } else {
            return;
        }
    }
}
