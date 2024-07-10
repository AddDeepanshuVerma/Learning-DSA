package BackTracking_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RateInMaze_BackTracking_2 {
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
        System.out.println(Arrays.deepToString(arr));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<String>();
        dfs(m, 0, 0, n, new StringBuilder(), ans);
        return !ans.isEmpty() ? ans : new ArrayList<>(List.of("-1"));
    }

    private static void dfs(int[][] grid, int row, int col, int n, StringBuilder sb, ArrayList<String> ans) {
        if (row == n - 1 && col == n - 1 && grid[row][col] == 1) {
            ans.add(sb.toString());
            return;
        }
        if (row >= n || row < 0 || col >= n || col < 0 || grid[row][col] == 0) return;

        grid[row][col] = 0;

        sb.append('D');
        dfs(grid, row + 1, col, n, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('U');
        dfs(grid, row - 1, col, n, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        dfs(grid, row, col + 1, n, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('L');
        dfs(grid, row, col - 1, n, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        grid[row][col] = 1;
    }
}