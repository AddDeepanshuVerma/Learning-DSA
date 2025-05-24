package Contest.Weekly_Contest._450;

import java.util.*;

public class Q3 {

    public int minMoves(String[] matrix) {
        int m = matrix.length, n = matrix[0].length();

        char[][] grid = new char[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = matrix[i].toCharArray();
        }
        System.out.println("grid = " + Arrays.deepToString(grid));

        HashMap<Character, List<int[]>> portals = new HashMap<>(); // A -> list of row & column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Character.isAlphabetic(grid[i][j])) {
                    portals.computeIfAbsent(grid[i][j], list -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        // now start with BFS
        ArrayDeque<int[]> q = new ArrayDeque<>(); // {row, col, time}
        if (Character.isAlphabetic(grid[0][0])) {
            for (int[] portal : portals.getOrDefault(grid[0][0], Collections.emptyList())) {
                int r = portal[0], c = portal[1];
                q.offerLast(new int[]{r, c, 0});
                visited[r][c] = true;
            }
        } else {
            q.offerLast(new int[]{0, 0, 0});
            visited[0][0] = true;
        }

        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();
            int r = poll[0], c = poll[1], t = poll[2];
            if (r == m - 1 && c == n - 1) return t; // reached destination

            for (int[] dir : dirs) {
                int r_ = r + dir[0], c_ = c + dir[1];
                if (r_ < 0 || r_ >= m || c_ < 0 || c_ >= n || grid[r_][c_] == '#' || visited[r_][c_]) continue;
                if (grid[r_][c_] == '.') {
                    q.offer(new int[]{r_, c_, t + 1});
                    visited[r_][c_] = true;
                } else {
                    for (int[] portal : portals.getOrDefault(grid[r_][c_], Collections.emptyList())) {
                        int portalR = portal[0], portalC = portal[1];
                        if (visited[portalR][portalC]) continue;
                        q.offerLast(new int[]{portalR, portalC, t + 1});
                        visited[portalR][portalC] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q3 obj = new Q3();

        String[] matrix = {".A", "CA"};
        int ans = obj.minMoves(matrix);
        System.out.println("ans = " + ans);
    }
}
