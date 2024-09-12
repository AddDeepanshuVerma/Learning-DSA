package Interesting;

import java.util.Arrays;

class RegionsBySlashes_959 {
    public static void main(String[] args) {
        String[] str = {"/\\","\\/"};
        RegionsBySlashes_959 obj = new RegionsBySlashes_959();
        System.out.println(obj.regionsBySlashes(str));

    }
    public int regionsBySlashes(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        int[][] matrix = new int[row * 3][col * 3];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '/') {
                    matrix[i * 3    ][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3    ] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    matrix[i * 3    ][j * 3     ] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
//        Arrays.stream(matrix).forEach(n -> System.out.println(Arrays.toString(n)));
        int region = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    region += 1;
                    DFS(matrix, i, j);
                }
            }
        }
        return region;
    }

    private void DFS(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == 1) {
            return;
        }
        matrix[i][j] = 1;

        DFS(matrix, i + 1, j);
        DFS(matrix, i - 1, j);
        DFS(matrix, i, j + 1);
        DFS(matrix, i, j - 1);
    }
}













