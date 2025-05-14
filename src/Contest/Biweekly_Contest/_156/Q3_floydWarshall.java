package Contest.Biweekly_Contest._156;

import java.util.Arrays;

public class Q3_floydWarshall {

    public int maxWeight(int n, int[][] edges, int k, int t) {
        int[][] distance = floydWarshall(n, edges, true);
        int[][] weight = floydWarshall(n, edges, false);

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == k && weight[i][j] < t) {
                    ans = Math.max(ans, weight[i][j]);
                }
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    private int[][] floydWarshall(int nv, int[][] edges, boolean equalWeight) {
        int[][] matrix = new int[nv][nv];

        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
            matrix[i][i] = 0;                                               // saves little time
        }

        if (equalWeight) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                matrix[u][v] = 1;
            }
        } else {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                matrix[u][v] = w;                    // if edges were undirected
            }
        }

        for (int k = 0; k < nv; k++) {
            for (int i = 0; i < nv; i++) {
                if (matrix[i][k] == Integer.MAX_VALUE) continue;            // saves our time by writing early
                for (int j = 0; j < nv; j++) {
                    if (matrix[k][j] == Integer.MAX_VALUE) continue;
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        Q3_floydWarshall obj = new Q3_floydWarshall();
        int n = 3, k = 2, t = 331;
        int[][] edges = {{1, 2, 9}, {0, 2, 4}, {0, 1, 7}};

        int ans = obj.maxWeight(n, edges, k, t);
        System.out.println("ans = " + ans);
    }
}
