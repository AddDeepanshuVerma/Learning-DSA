package _21_Graphs.algo_mikPlaylist.Algo;

import java.util.Arrays;

class _16Floyd_Warshall_Algo_classic {
    private int[][] floydWarshall(int nv, int[][] edges) {
        int[][] matrix = new int[nv][nv];

        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
            matrix[i][i] = 0;                                               // saves little time
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            matrix[u][v] = Math.min(matrix[u][v], w);
            matrix[v][u] = Math.min(matrix[v][u], w);                       // if edges were undirected
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
}