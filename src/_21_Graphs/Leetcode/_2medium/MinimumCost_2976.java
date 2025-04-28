package _21_Graphs.Leetcode._2medium;

class MinimumCost_2976 {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // apply floydWarshall on all lower case letters 26
        int[][] matrix = floydWarshall(original, changed, cost);

        long costToConvert = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            int tempCost = matrix[u][v];
            if (tempCost == Integer.MAX_VALUE) {
                return -1;
            }
            costToConvert += tempCost;
        }
        return costToConvert;
    }

    private int[][] floydWarshall(char[] original, char[] changed, int[] cost) {
        int[][] matrix = new int[26][26];

        // put all but diagonal as unReachable
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // now put all given edges/costs
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];
            matrix[u][v] = Math.min(matrix[u][v], w);
        }
        // now apply FloydWarshall where we'll go through all reachable vertices
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) continue;
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        return matrix;
    }
}