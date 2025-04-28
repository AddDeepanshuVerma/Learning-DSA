package Contest.Biweekly_Contest._155;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q3 {
    public int countCells(char[][] grid, String pattern) {
        int m = grid.length, n = grid[0].length;
        StringBuilder r = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                r.append(grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c.append(grid[j][i]);
            }
        }

        String row = r.toString();
        String col = c.toString();

        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        for (int i = 0; i <= row.length() - pattern.length(); i++) {
            if (check(i, pattern, row)) {
                rowList.add(i);
            }
            if (check(i, pattern, col)) {
                colList.add(i);
            }
        }

        HashSet<String> rowPair = new HashSet<>();
        for (int val : rowList) {
            rowPair.add(val / m + "_" + val % n);
        }

        int count = 0;
        for (Integer val : colList) {
            if (rowPair.contains(val % n + "-" + val / m)) {
                count++;
            }
        }
        return count;
    }


    private boolean check(int idx, String pattern, String row) {
        int i = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) != row.charAt(i + idx)) {
                return false;
            }
            i++;
            idx++;
        }
        return true;
    }
}
