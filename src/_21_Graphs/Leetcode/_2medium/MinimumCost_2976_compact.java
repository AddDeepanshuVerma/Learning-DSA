package _21_Graphs.Leetcode._2medium;

import java.util.Arrays;

class MinimumCost_2976_compact {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // apply floydWarshall on all lower case letters 26
        int[][] matrix = floydWarshall(original, changed, cost);

        long costToConvert = 0;
        for (int i = 0; i < source.length(); i++) {
            int tempCost = matrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (tempCost == Integer.MAX_VALUE) return -1;
            costToConvert += tempCost;
        }
        return costToConvert;
    }

    private int[][] floydWarshall(char[] original, char[] changed, int[] cost) {
        int[][] matrix = new int[26][26];

        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
            matrix[i][i] = 0;                                               // saves little time
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];
            matrix[u][v] = Math.min(matrix[u][v], w);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (matrix[i][k] == Integer.MAX_VALUE) continue;            // saves our time by writing early
                for (int j = 0; j < 26; j++) {
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