package _21_Graphs.Leetcode._2medium;

import java.util.Arrays;

class CountOfPairs_3015 {
    public static int[] countOfPairs(int n, int x, int y) {
        // create 2D matrix & put default values
        int[][] mat = new int[n + 1][n + 1];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
            mat[i][i] = 0;
        }
        // put given edges
        mat[x][y] = 1;
        mat[y][x] = 1;
        for (int i = 1; i <= n - 1; i++) {
            mat[i][i + 1] = 1;
            mat[i + 1][i] = 1;
        }
        // now apply FloydWarshall algo
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (mat[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 1; j <= n; j++) {
                    if (mat[k][j] == Integer.MAX_VALUE) continue;

                    if (mat[i][k] + mat[k][j] < mat[i][j]) {
                        mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }
        }
        // as 2D matrix is now ready hence we can calculate what is asked

        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || mat[i][j] == Integer.MAX_VALUE || mat[i][j] == 0) continue;
                ans[mat[i][j] - 1]++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = countOfPairs(5, 2, 4);
        System.out.println(Arrays.toString(arr));
    }
}