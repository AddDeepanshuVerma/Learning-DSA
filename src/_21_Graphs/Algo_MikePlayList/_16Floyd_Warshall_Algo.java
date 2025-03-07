package _21_Graphs.Algo_MikePlayList;

public class _16Floyd_Warshall_Algo {
    /*
     * Def : Find the shortest distance between every pair of vertices in any (Directed/UnDirected) Graph. (return type 2d Array)
     * Floyd Warshall says : in a pair of {u,v} try going via k & store the minimum finding; where k is every vertex in the Graph
     *
     * Steps :
     * 1. Create 2D matrix of Vertex x vertex
     * 2. Put all the given values of {u,v} edge and rest infinity in that 2D matrix
     * 3. Now for each value in 2D matrix: check them via for(int k = 0; k < n; k++)
     *    And store the minimum value.
     * 4. Result will be there in this 2D matrix itself.
     *
     * Note:
     * 1. Though we can calculate the same using Dijkstra like: call Dijkstra for each vertex
     * 2. we can also detect -ive cycle : in the resultant matrix if grid[i][j] != 0, where i == j ✨✨
     * 3. Then there was negative cycle.
     * */
    //TC : n^3
    public int[][] floydWarshallAlgo(int[][] mat) {
        final int INF = 10000; // grater then max value in the matrix
        int nv = mat.length;

        for (int i = 0; i < nv; i++)
            for (int j = 0; j < nv; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = INF;// In the given prob, -1 == no path hence change it to infinity
                }
                if (i == j) {
                    mat[i][j] = 0;// from same node or same node, we can reach in no time hence 0
                }
            }

        for (int k = 0; k < nv; k++) {
            for (int i = 0; i < nv; i++) {
                for (int j = 0; j < nv; j++) {
                    if (mat[i][k] + mat[k][j] < mat[i][j]) {
                        mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < nv; i++)
            for (int j = 0; j < nv; j++)
                if (mat[i][j] == INF) mat[i][j] = -1; // convert them back as per problem requirement

        // -iv cycle detection if asked.
        for (int i = 0; i < nv; i++)
            for (int j = 0; j < nv; j++)
                if (i == j && mat[i][j] < 0) { // would be less than 0 in -ive cycle case only
                    //-ive cycle detected
                }

        return mat;
    }
}
